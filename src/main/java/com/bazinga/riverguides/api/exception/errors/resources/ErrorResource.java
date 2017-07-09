package com.bazinga.riverguides.api.exception.errors.resources;

import java.util.List;

/**
 * Created by bazinga on 7/9/17.
 */
public class ErrorResource {
    private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    public ErrorResource() {
    }

    public ErrorResource(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
