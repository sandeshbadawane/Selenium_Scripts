package SeleniumScripts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class P13_ScreenShot {

	public static void main(String[] args) throws  Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

		// List<WebElement> ckbox=wd.findElements(By.xpath("//input[@type='checkbox']"));
		// for (WebElement c:ckbox )
		// {
		// Thread.sleep(1000);
		// c.click();
		// }
		TakesScreenshot ts=(TakesScreenshot) wd;
		File s=ts.getScreenshotAs(OutputType.FILE);
		File d=new File("./scr1.png");
		FileHandler.copy(s, d);

		}

		

	}


