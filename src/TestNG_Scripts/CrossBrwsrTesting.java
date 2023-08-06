package TestNG_Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrwsrTesting {
	WebDriver wd;
	@Test
	@Parameters ("brwsrName")
	public void f(String brName) throws Exception 
	{
		if (brName.equals("chrome"))
		{
		//	System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");		
			WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
		} 
		else if (brName.equals("edge"))
		{
			//System.setProperty("webdriver.edge.driver", "D:\\Java_Selenium_automation\\Edge_Driver\\msedgedriver.exe");	
			WebDriverManager.edgedriver().setup();
			wd=new EdgeDriver();
		}
		else
			System.out.println("Invalid brwsr name");

		wd.manage().window().maximize();
		wd.get("http://demo.frontaccounting.eu/");
		Thread.sleep(5000);
		wd.close();
	}
}

