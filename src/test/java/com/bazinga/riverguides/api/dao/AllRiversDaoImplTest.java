package com.bazinga.riverguides.api.dao;

import com.bazinga.riverguides.api.dao.impl.AllRiversDAOImpl;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.test.builders.RiversTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@SpringBootTest
@EntityScan(value = "com.bazinga.riverguides.api.test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager
@Transactional
public class AllRiversDaoImplTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AllRiversDAOImpl allRiversDAO;

    @Test
    @Rollback
    public void testGetAllRivers() {
        entityManager.persistAndFlush(new RiversTable.Builder()
                .withDefaultData()
                .build());

        List<River> riverList = allRiversDAO.getAllRivers();
        River river = riverList.get(0);

        assertEquals("There should only be 1 river in the list", 1, riverList.size());
        assertEquals("The River Name should be Dargle", "Dargle", river.getRiverName());
        assertEquals("The Fun Rating should be 10", "10", river.getFunRating());
        assertEquals("The Start Geo Coords should be 112.256365", (Double)112.256365, (Double)river.getStartGeoCoordsNorthings());
        assertEquals("The created date should be 2015-10-21 00:00:00", "2015-10-21 00:00:00", river.getCreatedDate());
    }
}
