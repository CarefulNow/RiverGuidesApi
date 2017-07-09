package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.models.RiverList;
import com.bazinga.riverguides.api.service.impl.AllRiversServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bazinga on 7/6/17.
 */
@Controller
@RequestMapping("/allrivers")
public class AllRiversController {
    @Autowired
    AllRiversServiceImpl allRiversService;

    @RequestMapping(value = "/getall", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RiverList getAllRivers() {
        RiverList riverList = allRiversService.getAllRivers();

        return riverList;
    }
}
