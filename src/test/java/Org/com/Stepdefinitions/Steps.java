package Org.com.Stepdefinitions;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import Org.com.Baseclass.Baseclass;
import Org.com.Pom.PageObjectManager;
import io.cucumber.java.en.Given;

public class Steps extends Baseclass{
	
	PageObjectManager pom=new PageObjectManager(driver);

	@Given("User Launch {string}")
	public void user_launch(String string) {
		Browserlaunch("chrome",string);
	}
	
	@Given("User clcik Edit Button")
	public void user_clcik_edit_button() {
	    elementClick(pom.getHomePage().Edit_Button);
	}
	
	@Given("User Enter E-mail {string}")
	public void user_enter_e_mail(String string) {
	   elementSendkeys(pom.getHomePage().UserMail, string);
	   WebelementHighlight(pom.getHomePage().UserMail, "yellow");
	}
}
