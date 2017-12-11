package com.bazinga.riverguides.api.dao;

import com.bazinga.riverguides.api.models.River;

public interface RiverDao {
    public boolean checkRiverExists(String riverName, String sectionName);

    public boolean addRiver(River river);

    public boolean updateRiver(River river);
}
