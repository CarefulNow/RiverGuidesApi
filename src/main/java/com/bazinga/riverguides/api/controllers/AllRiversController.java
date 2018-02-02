package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AllRiversServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rivers")
public class AllRiversController {
    @Autowired
    private AllRiversServiceImpl allRiversService;

    @RequestMapping(value = "/getall", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<River> getAllRivers() {
        List<River> riverList = allRiversService.getAllRivers();

        return riverList;
    }
}
