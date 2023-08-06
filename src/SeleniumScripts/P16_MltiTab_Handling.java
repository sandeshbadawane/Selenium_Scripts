package SeleniumScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P16_MltiTab_Handling {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		String pid=wd.getWindowHandle();
		Thread.sleep(2000);
		wd.findElement(By.id("opentab")).click();
		Set<String> alltab=wd.getWindowHandles();
		for (String t : alltab)
		{
		wd.switchTo().window(t);
		if(!(t.equals(pid)))
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




