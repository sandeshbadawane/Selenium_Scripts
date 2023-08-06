package SeleniumScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class P17_MultiTabHandle_witharray {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		String pid=wd.getWindowHandle();
		Thread.sleep(2000);
		wd.findElement(By.id("opentab")).click();
		Object[] alltab=wd.getWindowHandles().toArray();
		for (Object t : alltab)
		{
		wd.switchTo().window(t.toString());
		if(!(t.toString().equals(pid)))
		{
		Thread.sleep(3000);
		wd.findElement(By.linkText("Access all our Courses")).click();
		Thread.sleep(2000);
		wd.close();
		wd.switchTo().window(pid);
		}

		}

		wd.close();


	}

}
