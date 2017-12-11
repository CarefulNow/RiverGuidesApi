package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.models.RiverList;
import com.bazinga.riverguides.api.service.impl.AllRiversServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
public class AllRiversControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private AllRiversController allRiversController;

    @Mock
    private AllRiversServiceImpl allRiversService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(allRiversController).build();
    }

    @Test
    public void sampleTest() throws Exception {
        RiverList riverList = new RiverList();
        River river1 = new River();
        river1.setAuthor("Star Lord");
        river1.setCountry("Sweden");
        river1.setCreatedDate("10/17/2017");
        river1.setDescription("test description");
        river1.setEndGeoCoords(006.3121657);
        river1.setGrade("4(4+)");
        river1.setLastEditor("Baby star lord");
        river1.setLastUpdatedDate("11/17/2017");
        river1.setRegion("Stockholm");
        river1.setLength("6km");
        river1.setRiverName("test river");
        river1.setFunRating("0");
        river1.setSectionName("section 1");
        river1.setStartGeoCoords(112.256365);
        List<River> list = new ArrayList<>();
        list.add(river1);
        riverList.setRivers(list);

        Mockito.when(allRiversService.getAllRivers()).thenReturn(riverList);

        mockMvc.perform(get("/rivers/getall"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.rivers").isArray())
                .andExpect(jsonPath("$.rivers.river[0].riverName").value("test river"))
                .andExpect(content().json("{\"rivers\":[{\"river\":{\"riverName\":\"test river\"," +
                                "\"sectionName\":\"section 1\",\"region\":\"Stockholm\",\"country\":\"Sweden\"," +
                                "\"grade\":\"4(4+)\",\"length\":\"6km\",\"funRating\":\"0\"," +
                                "\"startGeoCoords\":112.256365,\"endGeoCoords\":6.3121657," +
                                "\"description\":\"test description\",\"author\":\"Star Lord\"," +
                                "\"createdDate\":\"10/17/2017\",\"lastUpdatedDate\":\"11/17/2017\",\"" +
                                "lastEditor\":\"Baby star lord\"}}]}"
                , true));
    }
}
