package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.exception.RequestException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.River;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rivers")
public class AddRiverController {


    @RequestMapping("/add")
    @ResponseBody
    public String addRiver(@Valid @RequestBody River newRiver, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new RequestException(bindingResult, RiverGuidesError.RIVER_GUIDES_INVALID_REQUEST_FIELDS);
        }

        return "Success";
    }
}
