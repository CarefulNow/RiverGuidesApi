package com.bazinga.riverguides.api.exception.errors;

import org.springframework.http.HttpStatus;

public enum RiverGuidesError {
    RIVER_GUIDES_INTERNAL_SERVER_ERROR("1001", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    RIVER_GUIDES_INVALID_REQUEST_FIELDS("1", "Invalid Request Fields", HttpStatus.BAD_REQUEST);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    RiverGuidesError(String code, String message, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
