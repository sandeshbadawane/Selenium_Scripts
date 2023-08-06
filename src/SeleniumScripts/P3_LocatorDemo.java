package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LocatorDemo {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.id Locator
		WebElement input= wd.findElement(By.id("autocomplete"));
		input.sendKeys("Id Locator");
		
		//2.Name Locator
		wd.findElement(By.name("enter-name")).sendKeys("Name Locator");
		//3.Class Locator
		//4.linkText
		wd.findElement(By.linkText("Open Tab")).click();
		//5.Partial link text
		//wd.findElement(By.partialLinkText("Open T")).click();
		
		//cssSelector
		//1) tagname#id
		
		//2) tagname[attribute=value of attribute]
		
		//3) tagname.className
		
	}

}
