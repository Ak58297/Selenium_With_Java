package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@Mobile")
	public void beforeMobile()
	{
		System.out.println("This hook will run before test");
	}
	
	@After("@Mobile")
	public void AfterMobile()
	{
		System.out.println("This hook will run before test");
	}
	
	

}
