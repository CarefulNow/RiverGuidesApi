package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.exception.RequestException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AddRiverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/management")
public class AddRiverController {
    @Autowired
    private AddRiverServiceImpl addRiverService;

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ManagementResponse addRiver(@Valid @RequestBody River newRiver, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new RequestException(bindingResult, RiverGuidesError.RIVER_GUIDES_INVALID_REQUEST_FIELDS);
        }
        ManagementResponse response = addRiverService.addRiver(newRiver);
        return response;
    }
}
