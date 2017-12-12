package com.bazinga.riverguides.api.service.impl;

import com.bazinga.riverguides.api.dao.impl.AllRiversDAOImpl;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.models.RiverList;
import com.bazinga.riverguides.api.service.AllRiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllRiversServiceImpl implements AllRiversService {
    @Autowired
    AllRiversDAOImpl allRiversDAO;

    @Override
    public RiverList getAllRivers() {
        RiverList riverList = new RiverList();
        List<River> rivers = allRiversDAO.getAllRivers();
        riverList.setRivers(rivers);
        return riverList;
    }
}
