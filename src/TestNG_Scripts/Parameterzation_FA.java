package TestNG_Scripts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class Parameterzation_FA {
	WebDriver wd;

	@BeforeSuite		
	public void openBrwsr()
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		

	}
	@Test(dataProvider = "dp")

	public void Login_FA(String un, String pwd) throws InterruptedException 
	{
		wd.navigate().to("http://demo.frontaccounting.eu/");
		Thread.sleep(2000);
		//Username
		WebElement uname=wd.findElement(By.name("user_name_entry_field"));
		uname.clear();
		uname.sendKeys(un);
		//password
		WebElement passwd=wd.findElement(By.name("password"));
		passwd.clear();
		passwd.sendKeys(pwd);
		//Login button
		wd.findElement(By.name("SubmitUser")).click();

		Thread.sleep(2000);	
		wd.findElement(By.linkText("Logout")).click();


	}
	@AfterTest
	public void closeBrswr() throws Exception
	{
		Thread.sleep(2000);
		wd.close();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "demouser", "password" },
			new Object[] { "demouser", "password" },
			new Object[] { "demouser", "password" },
			new Object[] { "demouser", "password" },
		};
	}
}
