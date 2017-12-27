package com.bazinga.riverguides.api.cucumber.steps;

import com.bazinga.riverguides.api.Application;
import com.bazinga.riverguides.api.test.builders.RiversTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

//@AutoConfigureDataJpa
//@EntityScan(value = "com.bazinga.riverguides.api.test")
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@AutoConfigureTestEntityManager
//@Transactional
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class RiverRequestStepDefs {
    private MockMvc mockmvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //@Autowired
    //private TestEntityManager entityManager;

    private ResultActions resultActions;

    @Before
    public void setUp() {
        mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Given("^The user wants River guides from the application$")
    public void the_user_wants_River_guides_from_the_application() throws Throwable {
       // entityManager.persistAndFlush(new RiversTable.Builder()
         //       .withDefaultData()
           //     .build());
    }

    @When("^The user sends a GET request to \"([^\"]*)\"$")
    public void the_user_sends_a_GET_request_to(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The user should receive information about (\\d+) rivers$")
    public void the_user_should_receive_information_about_rivers(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The river name should be \"([^\"]*)\" and section name should be \"([^\"]*)\"$")
    public void the_river_name_should_be_and_section_name_should_be(String riverName, String sectionName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("The river name should equal the response", riverName, "");
        assertEquals("The section name should equal the response", sectionName, "");
        throw new PendingException();
    }
}
