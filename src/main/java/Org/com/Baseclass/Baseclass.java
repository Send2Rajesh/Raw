package Org.com.Baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
public static WebDriver driver;
public static WebDriverWait wb;
	public static WebDriver Browser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\");
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
return driver;
	}
	
	public static void getUrl(String value) {
	driver.get(value);
	}
	
	public static void windowMaximize() {
driver.manage().window().maximize();
	}
	
	public static void Browserlaunch(String BrowserName,String Url) {
		Browser(BrowserName);
		getUrl(Url);
		windowMaximize();
	}
	
	
	public static void elementClick(WebElement element) {
try {
	WaitforVisibility_of_Element(element);
	wb.until(ExpectedConditions.elementToBeClickable(element)).click();
} catch (Exception e) {
	JS_Click(element);
	System.err.println("Unable to Click: "+e.getMessage());
}
	}
	
	public static void elementSendkeys(WebElement element,String Value) {
try {
	WaitforVisibility_of_Element(element);
	element.sendKeys(Value);
} catch (Exception e) {
	System.err.println("Unable to Enter Value: "+e.getMessage());
}
	}
	
	public static void WebelementHighlight(WebElement element,String color) {
		try {
			String javascript = "arguments[0].setAttribute('style','background: ; border: 2px solid yellow;');";  
			
			if (color.equalsIgnoreCase("YELLOW")) {
				javascript= "arguments[0].setAttribute('style','background: ; border: 2px solid yellow;');";
			}else if (color.equalsIgnoreCase("RED")) {
				javascript = "arguments[0].setAttribute('style','background: ; border: 2px solid red;');";  
			}else if (color.equalsIgnoreCase("GREEN")) {
				javascript = "arguments[0].setAttribute('style','background: ; border: 2px solid green;');";  
			}
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(javascript, element);
		} catch (Exception e) {
			System.err.println("Unable to draw : "+e.getMessage());
		}
	}
	
	public static void WaitforVisibility_of_Element(WebElement element) {
		try {
			wb.until(ExpectedConditions.visibilityOf(element));
			Actions a=new Actions(driver);
			a.moveToElement(element).build().perform();
			WebelementHighlight(element, "yellow");
		} catch (Exception e) {
			System.err.println("Unable to locate WebElement : "+e.getMessage());
		}
	}
	
	public static void JS_Click(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Unable to Perform JS-Click :"+e.getMessage());
		}
	}
	
	public static byte[] Report_Screenshot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		}
	
	
}
