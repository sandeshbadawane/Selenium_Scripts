package SeleniumScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class P12_Is_Enabled_Demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.navigate().to("https://simplehai.axisdirect.in/");
		wd.findElement(By.xpath("//*[@id=\"main\"]/header/div[3]/div/div[1]/div[2]/ul/li[2]/a")).click();
		System.out.println(wd.findElement(By.id("loginButtonM")).isEnabled());

		}
	}


