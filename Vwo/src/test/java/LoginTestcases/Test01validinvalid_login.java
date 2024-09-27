package LoginTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test01validinvalid_login {
	WebDriver driver;
	ChromeOptions option;
	@BeforeSuite
	public void setup() {
		
		option=new ChromeOptions();
		option.addArguments("--window-maximized");
		driver=new ChromeDriver(option);
	}
	@Test
	public void invalidTC(){
		driver.get("https://katalon-demo-cura.herokuapp.com");
		driver.findElement(By.id("btn-make-appointment")).click();
		//p[@class="lead text-danger"]
		
		//Verifying first page
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder=\"Username\"])[2]")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		
		//Verifying second page
		//Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
		driver.findElement(By.id("sidebar-wrapper")).click();
	
		driver.findElement(By.xpath("//a[@href=\"authenticate.php?logout\"]")).click();
		
	}
		
		
		
		
	}

