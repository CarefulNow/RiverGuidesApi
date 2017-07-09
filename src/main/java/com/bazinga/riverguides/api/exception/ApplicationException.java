package com.bazinga.riverguides.api.exception;

import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;

/**
 * Created by bazinga on 7/9/17.
 */
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
