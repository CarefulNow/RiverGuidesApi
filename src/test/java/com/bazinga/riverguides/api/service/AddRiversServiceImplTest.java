package com.bazinga.riverguides.api.service;

import com.bazinga.riverguides.api.dao.impl.RiverDaoImpl;
import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AddRiverServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AddRiversServiceImplTest {
    @InjectMocks
    private AddRiverServiceImpl addRiverService;

    @Mock
    private RiverDaoImpl riverDao;

    @Test
    public void testAddRiverAlreadyExists() {
        when(riverDao.checkRiverExists(any(String.class), any(String.class))).thenReturn(true);

        River testRiver = new River();
        testRiver.setRiverName("Dargle");
        testRiver.setSectionName("Main Section");

        ManagementResponse result = addRiverService.addRiver(testRiver);

        assertEquals("Response should say the river already exists", "River Already Exists", result.getMessage());
    }

    @Test
    public void testAddRiverDoesNotExist() {
        when(riverDao.checkRiverExists(any(String.class), any(String.class))).thenReturn(false);

        River testRiver = new River();
        testRiver.setRiverName("Dargle");
        testRiver.setSectionName("Main Section");

        ManagementResponse result = addRiverService.addRiver(testRiver);

        assertEquals("Response should say the river does not exist", "River Does Not Exist", result.getMessage());
    }
}
