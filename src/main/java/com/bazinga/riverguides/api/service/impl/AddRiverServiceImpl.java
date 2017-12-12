package com.bazinga.riverguides.api.service.impl;

import com.bazinga.riverguides.api.dao.impl.RiverDaoImpl;
import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.AddRiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRiverServiceImpl implements AddRiverService {
    @Autowired
    private RiverDaoImpl riverDao;

    @Override
    public ManagementResponse addRiver(River river) {
        ManagementResponse response = new ManagementResponse();
        boolean isRiverPresent = riverDao.checkRiverExists(river.getRiverName(), river.getSectionName());
        if(isRiverPresent) {
            response.setMessage("River Already Exists");
        } else {
            response.setMessage("River Does Not Exist");
        }
        return response;
    }
}
