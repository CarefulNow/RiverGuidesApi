package com.bazinga.riverguides.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by bazinga on 7/6/17.
 */

public class RiverList {
    @JsonProperty("riverList")
    List<River> rivers;

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
