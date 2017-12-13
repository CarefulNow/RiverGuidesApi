package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.exception.RequestException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AddRiverServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/management")
public class AddRiverController {
    private static Logger logger = LoggerFactory.getLogger(AddRiverController.class);

    @Autowired
    private AddRiverServiceImpl addRiverService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ManagementResponse addRiver(@Valid @RequestBody River newRiver, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            logger.error("The request contained validation errors" + newRiver.toString());
            throw new RequestException(bindingResult, RiverGuidesError.RIVER_GUIDES_INVALID_REQUEST_FIELDS);
        }
        ManagementResponse response = addRiverService.addRiver(newRiver);
        return response;
    }
}
