package com.bazinga.riverguides.api.dao;

import com.bazinga.riverguides.api.dao.impl.RiverDaoImpl;
import com.bazinga.riverguides.api.test.RiversTable;
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@SpringBootTest
@EntityScan(value = "com.bazinga.riverguides.api.test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager
@Transactional
public class RiverDaoImplTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RiverDaoImpl riverDao;

    @Test
    @Rollback
    public void testCheckRiverExistsWhenRiverExists() {
        entityManager.persistAndFlush(new RiversTable.Builder()
                .withDefaultData()
                .build());

        boolean result = riverDao.checkRiverExists("Dargle", "Main Section");

        assertTrue("The river should exist in the database", result);
    }

    @Test
    @Rollback
    public void testCheckRiverExistsWhenRiverDoesNotExist() {
        entityManager.persistAndFlush(new RiversTable.Builder()
                .withDefaultData()
                .build());

        boolean result = riverDao.checkRiverExists("Dargle", "Gorge");

        assertFalse("The river should exist in the database", result);
    }
}
