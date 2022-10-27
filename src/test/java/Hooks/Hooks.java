package Hooks;


import Org.com.Baseclass.Baseclass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass {

	@AfterStep
	public void AfterHooks(Scenario scenario) {
		String Step = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
		scenario.attach(Report_Screenshot(), "image/png", Step);
		System.out.println("Step-Status ==> "+scenario.getStatus());
		
		//System.out.println("Number of lines : "+id);
	}
	
}
