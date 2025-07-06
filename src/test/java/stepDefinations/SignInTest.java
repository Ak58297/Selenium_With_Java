package stepDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInTest {

	
	
	@Given("Chrome browser is invoked")
    public void chrome_browser_is_invoked() {
      System.out.println("chrome invoked---------------------------->");
    }
	@When("Prerequisite when")
	  public void prerequisite_when() {
	        System.out.println("Executing precondition step under When phase.");
	    }

    @And("I am landed on amazaon home page")
    public void i_am_landed_on_amazon_home_page() {
        System.out.println("And chrome invoked------------------------------------------>");

    }
    @Then("Prerequisite then")
    public void prerequisite_then() {
        System.out.println("Verifying prerequisite Then condition.");
            }
	
	@Given("User is on amazon homepage")
	public void user_is_on_amazon_homepage() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@Given("page is loaded")
	public void page_is_loaded() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@When("user clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@When("enter valid user name and password")
	public void enter_valid_user_name_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@Then("user will be navigated to home page")
	public void user_will_be_navigated_to_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@Then("user name will appear")
	public void user_name_will_appear() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Hi");
	}

	@Given("^I want to write a step with (.+)$")
	public void i_want_to_write_a_step_with(String name) {
		System.out.println("Name passed: " + name);
		// You can also assert something here or log based on the name
	}

	@When("I check for the {int} in step")
	public void i_check_for_the_value_in_step(int value) {
		System.out.println("Value passed: " + value);
		// Example: check if value is within expected range
	}

	@Then("^I verify the (.+) in step$")
	public void i_verify_the_status_in_step(String status) {
		System.out.println("Status passed: " + status);
		// Add actual verification logic here
	}
	
	
	@Then("the following details will appear")
	public void the_following_details_will_appear(DataTable data) {
	List<String> obj=	data.row(0);
	
		System.out.println(obj.get(0));
		System.out.println(obj.get(1));

		System.out.println(obj.get(2));

		System.out.println(obj.get(3));

	}

}
