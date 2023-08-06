package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P7_DropDown_BlazeDemo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://blazedemo.com/");
		Thread.sleep(2000);
		Select sel;
		//DropDown
		sel=new Select(wd.findElement(By.name("fromPort")));
		//1. by Index
		sel.selectByIndex(2);
		//2. by value
		sel.selectByValue("Philadelphia");
		Thread.sleep(1000);
		//3. by visible text
		sel.selectByVisibleText("São Paolo");
		Thread.sleep(1000);
		//DropDown
		sel=new Select(wd.findElement(By.name("toPort")));	
		sel.selectByValue("Berlin");
		Thread.sleep(1000);
		wd.close();
		
	}

}
