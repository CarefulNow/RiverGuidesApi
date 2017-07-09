package com.bazinga.riverguides.api.dao.impl;

import com.bazinga.riverguides.api.dao.AllRiversDAO;
import com.bazinga.riverguides.api.dao.rowmapper.RiverRowMapper;
import com.bazinga.riverguides.api.models.River;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bazinga on 7/8/17.
 */

@Repository
public class AllRiversDAOImpl implements AllRiversDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<River> getAllRivers() {
        String sql = "SELECT * FROM rivers";

        List<River> result = namedParameterJdbcTemplate.query(sql, new RiverRowMapper());
        return result;
    }
}
