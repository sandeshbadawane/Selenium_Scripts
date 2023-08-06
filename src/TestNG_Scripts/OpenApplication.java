package TestNG_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenApplication {
	WebDriver wd;

	@BeforeMethod
	public void openBrwsr()
	{
//		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
//		//		WebDriver wd = new ChromeDriver();
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		
		
	}

	@Test
	public void openFA() throws Exception
	{
		wd.get("http://demo.frontaccounting.eu/");
		Thread.sleep(2000);
	}
	@Test
	public void openOrange() throws Exception
	{
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeBrswr() throws Exception
	{
		Thread.sleep(4000);
		wd.close();
	}

}
