package com.bazinga.riverguides.api.exception;

import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;

public class ApplicationException extends RuntimeException {
    private RiverGuidesError riverGuidesError;

    public ApplicationException(RiverGuidesError riverGuidesError) {
        super(riverGuidesError.toString());
        this.riverGuidesError = riverGuidesError;
    }

    public RiverGuidesError getRiverGuidesError() {
        return riverGuidesError;
    }
}
