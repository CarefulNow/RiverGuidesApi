package com.bazinga.riverguides.api.dao.impl;

import com.bazinga.riverguides.api.dao.AllRiversDAO;
import com.bazinga.riverguides.api.dao.rowmapper.RiverRowMapper;
import com.bazinga.riverguides.api.exception.ApplicationException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.River;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        List<River> result;
        String sql = "SELECT * FROM rivers";

        try {
            result = namedParameterJdbcTemplate.query(sql, new RiverRowMapper());
        } catch (DataAccessException e) {
            throw new ApplicationException(RiverGuidesError.RIVER_GUIDES_INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
