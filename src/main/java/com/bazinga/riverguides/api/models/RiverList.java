package com.bazinga.riverguides.api.models;

import java.util.ArrayList;
import java.util.List;

public class RiverList {

    private List<River> rivers;

    public RiverList() {
    }

    public RiverList(List<River> rivers) {
        this.rivers = rivers;
    }

    public List<River> getRivers() {
        return rivers;
    }

    public void setRivers(List<River> rivers) {
        this.rivers = rivers;
    }
}
