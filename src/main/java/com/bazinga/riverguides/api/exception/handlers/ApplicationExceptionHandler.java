package com.bazinga.riverguides.api.exception.handlers;

import com.bazinga.riverguides.api.exception.ApplicationException;
import com.bazinga.riverguides.api.exception.errors.resources.ErrorResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by bazinga on 7/9/17.
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ApplicationException.class})
    protected ResponseEntity<Object> applicationExceptionHandler(RuntimeException runtime, WebRequest request) {
        ApplicationException e = (ApplicationException) runtime;

        ErrorResource errorResource = new ErrorResource(e.getRiverGuidesError().getCode(), e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        return handleExceptionInternal(e, errorResource, httpHeaders, e.getRiverGuidesError().getHttpStatus(), request);
    }
}
