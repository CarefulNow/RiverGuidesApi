package com.bazinga.riverguides.api.service;

import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;

public interface AddRiverService {
    public ManagementResponse addRiver(River river);
}
