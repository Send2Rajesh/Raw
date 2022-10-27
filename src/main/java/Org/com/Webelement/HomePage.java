package Org.com.Webelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.com.Baseclass.Baseclass;

public class HomePage extends Baseclass {

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Edit")
	public WebElement Edit_Button;
	
	@FindBy(id = "email")
	public WebElement UserMail;
	
}
