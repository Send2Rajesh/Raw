package Org.com.Pom;

import org.openqa.selenium.WebDriver;

import Org.com.Baseclass.Baseclass;
import Org.com.Webelement.HomePage;

public class PageObjectManager extends Baseclass{

	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	private HomePage HomePage;

	public HomePage getHomePage() {
		if (HomePage==null) {
			HomePage=new HomePage(driver);
		}
		return HomePage;
	}
	
	
	
}
