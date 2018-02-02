package com.bazinga.riverguides.api.service.impl;

import com.bazinga.riverguides.api.dao.impl.AllRiversDAOImpl;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.AllRiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllRiversServiceImpl implements AllRiversService {
    @Autowired
    private AllRiversDAOImpl allRiversDAO;

    @Override
    public List<River> getAllRivers() {
        List<River> rivers = allRiversDAO.getAllRivers();
        return rivers;
    }
}
