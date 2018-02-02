package com.bazinga.riverguides.api.cucumber.steps;

import com.bazinga.riverguides.api.Application;
import com.bazinga.riverguides.api.test.builders.RiversTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureDataJpa
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager
@Transactional
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class RiverRequestStepDefs {
    private MockMvc mockmvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TestEntityManager entityManager;

    private ResultActions resultActions;

    @Before
    public void setUp() {
        mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Given("^The user wants River guides from the application$")
    public void the_user_wants_River_guides_from_the_application() {
       entityManager.persistAndFlush(new RiversTable.Builder()
                .withDefaultData()
                .build());
    }

    @When("^The user sends a GET request to \"([^\"]*)\"$")
    public void the_user_sends_a_GET_request_to(String path) throws Exception {
        resultActions = mockmvc.perform(get(path));
    }

    @Then("^The river name should be \"([^\"]*)\" and section name should be \"([^\"]*)\"$")
    public void the_river_name_should_be_and_section_name_should_be(String riverName, String sectionName) throws Exception {
        resultActions.andDo(print());
        resultActions.andExpect(jsonPath("$[0].river.riverName", is(riverName)));
        resultActions.andExpect(jsonPath("$[0].river.sectionName", is(sectionName)));
    }
}
