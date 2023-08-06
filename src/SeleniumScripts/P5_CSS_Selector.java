package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_CSS_Selector {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		//cssSelector
		//1) tagname#id
			wd.findElement(By.cssSelector("input#autocomplete")).sendKeys("Id Locator");
		//2) tagname[attribute=value of attribute]
			wd.findElement(By.cssSelector("input[value=Hide]")).click();
		//3) tagname.className
			
	}

}
