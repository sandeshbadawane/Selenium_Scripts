package SeleniumScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P8_Alert_Front_Accounting {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("http://demo.frontaccounting.eu/");
		Thread.sleep(2000);
//		String a= wd.getTitle();
//		System.out.println(a);
//		if (a.equals("FrontAccounting 2.4.12 - Login")) 
//		{
//			System.out.println("PASS");
//		} else 
//		{
//			System.out.println("FAIL");
//		}
		//Username
		WebElement uname=wd.findElement(By.name("user_name_entry_field"));
		uname.clear();
		uname.sendKeys("demouser");
		//password
		WebElement passwd=wd.findElement(By.name("password"));
		passwd.clear();
		passwd.sendKeys("password");
		//Login button
		wd.findElement(By.name("SubmitUser")).click();
		//Sales Quotation Entry
		wd.findElement(By.linkText("Sales Quotation Entry")).click();
		//wd.findElement(By.xpath("//a[@class='menu_option'][1]")).click();
		//wd.findElement(By.xpath("////a[@accesskey='Q']")).click();
		//Click on cancel button
		wd.findElement(By.className("inputsubmit")).click();
		// Alert
		Alert alt=wd.switchTo().alert();
		System.out.println("Alert text- " +alt.getText());
		Thread.sleep(2000);
		//alt.accept();//OK button
		alt.dismiss(); //Cancel button
		
	}

}
