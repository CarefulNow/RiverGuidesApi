package com.bazinga.riverguides.api.exception.handlers;

import com.bazinga.riverguides.api.exception.RequestException;
import com.bazinga.riverguides.api.exception.errors.resources.ErrorResource;
import com.bazinga.riverguides.api.exception.errors.resources.FieldErrorResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({RequestException.class})
    protected ResponseEntity<Object> requestExceptionHandler(RuntimeException runtime, WebRequest request) {
        RequestException re = (RequestException) runtime;
        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        List<FieldError> fieldErrors = re.getErrors().getFieldErrors();
        for(FieldError fieldError : fieldErrors) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        ErrorResource requestErrorResource = new ErrorResource(re.getRiverGuidesError().getCode(), re.getMessage());
        requestErrorResource.setFieldErrors(fieldErrorResources);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        return handleExceptionInternal(re, requestErrorResource, httpHeaders, re.getRiverGuidesError().getHttpStatus(), request);
    }
}
