package com.bazinga.riverguides.api.service;

import com.bazinga.riverguides.api.dao.impl.AllRiversDAOImpl;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AllRiversServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AllRiversServiceImplTest {
    @InjectMocks
    private AllRiversServiceImpl allRiversService;

    @Mock
    private AllRiversDAOImpl allRiversDAO;

    @Test
    public void testGetAllRivers() {
        River river1 = new River();
        river1.setRiverName("river1");
        River river2 = new River();
        river2.setRiverName("river2");
        List<River> riverList = new ArrayList<>();
        riverList.add(river1);
        riverList.add(river2);
        when(allRiversDAO.getAllRivers()).thenReturn(riverList);

        List<River> result = allRiversService.getAllRivers();
        assertEquals("The list in Riverlist contains two entries", 2, result.size());
        assertEquals("River 1 is in the list", "river1", result.get(0).getRiverName());
        assertEquals("River 2 is in the list", "river2", result.get(1).getRiverName());
    }
}
