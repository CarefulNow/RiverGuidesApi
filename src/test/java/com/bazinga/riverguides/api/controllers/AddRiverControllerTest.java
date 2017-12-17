package com.bazinga.riverguides.api.controllers;

import com.bazinga.riverguides.api.exception.ApplicationException;
import com.bazinga.riverguides.api.exception.errors.RiverGuidesError;
import com.bazinga.riverguides.api.exception.handlers.ApplicationExceptionHandler;
import com.bazinga.riverguides.api.exception.handlers.RequestExceptionHandler;
import com.bazinga.riverguides.api.models.ManagementResponse;
import com.bazinga.riverguides.api.models.River;
import com.bazinga.riverguides.api.service.impl.AddRiverServiceImpl;
import com.bazinga.riverguides.api.test.RiverGuidesTestUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class AddRiverControllerTest {
    private MockMvc mockMvc;

    private MockMvc mockMvcWithApplcationExceptionHandler;

    @InjectMocks
    private AddRiverController addRiversController;

    @Mock
    private AddRiverServiceImpl addRiverService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(addRiversController)
                .setControllerAdvice(new RequestExceptionHandler())
                .build();
        mockMvcWithApplcationExceptionHandler = MockMvcBuilders.standaloneSetup(addRiversController)
                .setControllerAdvice(new ApplicationExceptionHandler())
                .build();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        response.setMessage("River Does Not Exist");

        when(addRiverService.addRiver(any(River.class))).thenReturn(response);

        mockMvc.perform(post("/management/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.response.message", is("River Does Not Exist")));
    }

    @Test
    public void testAddRiverControllerWithDescriptionValidationErrors() throws Exception {
        River testRiver = new River();
        testRiver.setRiverName("Ottawa");
        testRiver.setSectionName("Rocher-Fendu");
        testRiver.setEndGeoCoordsEastings(113.2569874);
        testRiver.setLength("5Km");
        testRiver.setAuthor("Morty");
        testRiver.setFunRating("9");
        testRiver.setLastEditor("Rick");
        testRiver.setCountry("Canada");
        testRiver.setGrade("4/4+");
        testRiver.setRegion("Ottawa");
        testRiver.setCreatedDate("2017-07-07 19:30:00");
        testRiver.setLastUpdatedDate("2017-07-07 19:30:00");

        mockMvc.perform(post("/management/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.code", is("1")))
                .andExpect(jsonPath("$.message", is("1: Invalid Request Fields")))
                .andExpect(jsonPath("$.fieldErrors[0].resource", is("river")))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("description")))
                .andExpect(jsonPath("$.fieldErrors[0].code", is("NotNull")))
                .andExpect(jsonPath("$.fieldErrors[0].message", is("may not be null")));
    }

    @Test
    public void testAddRiverControllerWithSectionNameValidationErrors() throws Exception {
        River testRiver = new River();
        testRiver.setRiverName("Ottawa");
        testRiver.setEndGeoCoordsEastings(113.2569874);
        testRiver.setLength("5Km");
        testRiver.setAuthor("Morty");
        testRiver.setFunRating("9");
        testRiver.setLastEditor("Rick");
        testRiver.setCountry("Canada");
        testRiver.setDescription("wow");
        testRiver.setGrade("4/4+");
        testRiver.setRegion("Ottawa");
        testRiver.setCreatedDate("2017-07-07 19:30:00");
        testRiver.setLastUpdatedDate("2017-07-07 19:30:00");

        mockMvc.perform(post("/management/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.code", is("1")))
                .andExpect(jsonPath("$.message", is("1: Invalid Request Fields")))
                .andExpect(jsonPath("$.fieldErrors[0].resource", is("river")))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("sectionName")))
                .andExpect(jsonPath("$.fieldErrors[0].code", is("NotNull")))
                .andExpect(jsonPath("$.fieldErrors[0].message", is("may not be null")));
    }

    @Test
    public void testAddRiverControllerWithAuthorValidationErrors() throws Exception {
        River testRiver = new River();
        testRiver.setRiverName("Ottawa");
        testRiver.setEndGeoCoordsEastings(113.2569874);
        testRiver.setLength("5Km");
        testRiver.setSectionName("Rocher-Fendu");
        testRiver.setFunRating("9");
        testRiver.setLastEditor("Rick");
        testRiver.setCountry("Canada");
        testRiver.setDescription("wow");
        testRiver.setGrade("4/4+");
        testRiver.setRegion("Ottawa");
        testRiver.setCreatedDate("2017-07-07 19:30:00");
        testRiver.setLastUpdatedDate("2017-07-07 19:30:00");

        mockMvc.perform(post("/management/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.code", is("1")))
                .andExpect(jsonPath("$.message", is("1: Invalid Request Fields")))
                .andExpect(jsonPath("$.fieldErrors[0].resource", is("river")))
                .andExpect(jsonPath("$.fieldErrors[0].field", is("author")))
                .andExpect(jsonPath("$.fieldErrors[0].code", is("NotNull")))
                .andExpect(jsonPath("$.fieldErrors[0].message", is("may not be null")));
    }

    @Test
    public void testAddRiverControllerWithInternalServerError() throws Exception {
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

        when(addRiverService.addRiver(any(River.class))).thenThrow(new ApplicationException(RiverGuidesError.RIVER_GUIDES_INTERNAL_SERVER_ERROR));

        mockMvcWithApplcationExceptionHandler.perform(post("/management/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(RiverGuidesTestUtils.convertObjectToJsonString(testRiver)))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.code", is("1001")))
                .andExpect(jsonPath("$.message", is("1001: Internal Server Error")));
    }
}
