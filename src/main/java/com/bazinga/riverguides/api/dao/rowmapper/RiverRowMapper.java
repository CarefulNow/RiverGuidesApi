package com.bazinga.riverguides.api.dao.rowmapper;

import com.bazinga.riverguides.api.constants.RiverGuidesConstants;
import com.bazinga.riverguides.api.exception.ApplicationException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.models.River;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RiverRowMapper implements RowMapper<River> {
    private DateTimeFormatter dtf = DateTimeFormat.forPattern(RiverGuidesConstants.DATE_TIME_FORMAT_PATTERN);

    @Override
    public River mapRow(ResultSet resultSet, int i) throws ApplicationException {
        try {
            River river = new River();
            river.setRiverName(resultSet.getString("river_name"));
            river.setSectionName(resultSet.getString("section_name"));
            river.setRegion(resultSet.getString("region"));
            river.setCountry(resultSet.getString("country"));
            river.setGrade(resultSet.getString("grade"));
            river.setFunRating(resultSet.getString("fun_rating"));
            river.setStartGeoCoords(resultSet.getDouble("start_geo_coords"));
            river.setEndGeoCoords(resultSet.getDouble("end_geo_coords"));
            river.setDescription(resultSet.getString("description"));
            river.setAuthor(resultSet.getString("author"));
            river.setCreatedDate(new DateTime(resultSet.getDate("created_date")).toString(dtf));
            river.setLastUpdatedDate(new DateTime(resultSet.getDate("last_updated_date")).toString(dtf));
            river.setLastEditor(resultSet.getString("last_editor"));
            return river;
        } catch (SQLException e) {
            throw new ApplicationException(RiverGuidesError.RIVER_GUIDES_INTERNAL_SERVER_ERROR);
        }
    }
}
