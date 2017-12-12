package com.bazinga.riverguides.api.dao.impl;

import com.bazinga.riverguides.api.dao.RiverDao;
import com.bazinga.riverguides.api.exception.ApplicationException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.River;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RiverDaoImpl implements RiverDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean checkRiverExists(String riverName, String sectionName) {
        int result;

        StringBuilder sql = new StringBuilder()
                .append("SELECT COUNT(*) ")
                .append("FROM rivers ")
                .append("WHERE river_name = :riverName ")
                .append("AND section_name = :sectionName");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("riverName", riverName)
                .addValue("sectionName", sectionName);

        try {
            result = namedParameterJdbcTemplate.queryForObject(sql.toString(), parameterSource, Integer.class);
        } catch (DataAccessException dae) {
            throw new ApplicationException(RiverGuidesError.RIVER_GUIDES_INTERNAL_SERVER_ERROR);
        }
        return (result > 0);
    }

    @Override
    public boolean addRiver(River river) {
        return false;
    }

    @Override
    public boolean updateRiver(River river) {
        return false;
    }
}
