package com.bazinga.riverguides.api.exception;

import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import org.springframework.validation.Errors;

/**
 * Created by bazinga on 7/9/17.
 */
public class RequestException extends RuntimeException {
    private Errors errors;
    private RiverGuidesError riverGuidesError;

    public RequestException(Errors errors, RiverGuidesError riverGuidesError) {
        super(riverGuidesError.toString());
        this.errors = errors;
        this.riverGuidesError = riverGuidesError;
    }

    public Errors getErrors() {
        return errors;
    }

    public RiverGuidesError getRiverGuidesError() {
        return riverGuidesError;
    }
}
