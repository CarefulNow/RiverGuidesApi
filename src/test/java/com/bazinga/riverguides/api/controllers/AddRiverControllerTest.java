package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AddRiverServiceImpl;
import com.bazinga.riverguides.api.test.RiverGuidesTestUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public class AddRiverControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private AddRiverController addRiversController;

    @Mock
    private AddRiverServiceImpl addRiverService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(addRiversController).build();
    }

    @Test
    public void testAddRiverController() throws Exception {
        River testRiver = new River();
        testRiver.setRiverName("Ottawa");
        testRiver.setSectionName("Rocher-Fendu");
        testRiver.setEndGeoCoordsEastings(113.2569874);
        testRiver.setLength("5Km");
        testRiver.setAuthor("Morty");
        testRiver.setFunRating("9");
        testRiver.setLastEditor("Rick");
        testRiver.setCountry("Canada");
        testRiver.setDescription("Wow");
        testRiver.setGrade("4/4+");
        testRiver.setRegion("Ottawa");
        testRiver.setCreatedDate("2017-07-07 19:30:00");
        testRiver.setLastUpdatedDate("2017-07-07 19:30:00");

        ManagementResponse response = new ManagementResponse();
        response.setMessage("River Does Not exist");

        when(addRiverService.addRiver(eq(testRiver))).thenReturn(response);

        mockMvc.perform(post("/management/add").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.response.message", is("River Does Not Exist")));
    }
}
