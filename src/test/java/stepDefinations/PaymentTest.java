package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentTest {
	
	
	@Given("I want to write a step with preconditionn")
    public void i_want_to_write_a_step_with_precondition() {
        System.out.println("Setting up the precondition...");
    }

    @When("I complete actionn")
    public void i_complete_action() {
        System.out.println("Performing the main action...");
    }

    @Then("I validate the outcomess")
    public void i_validate_the_outcomes() {
        System.out.println("Validating results...");
    }

	

}
