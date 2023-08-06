package TestNG_Scripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Multiple_Menus {
	WebDriver wd;

	@BeforeSuite		
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
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@BeforeTest
	public void openAppl() 
	{
		wd.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@BeforeClass
	public void Login() 
	{
		//Username
		wd.findElement(By.name("username")).sendKeys("Admin");
		//password
		wd.findElement(By.name("password")).sendKeys("admin123");
		//Login button
		wd.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}
	@Test
	public void openMenuLeave() 
	{
		wd.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
	}
	@Test
	public void openMenuPerformance() 
	{
		wd.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a/span")).click();
	}
	@AfterClass
	public void logout() 
	{
		wd.findElement(By.className("oxd-userdropdown-tab")).click();
		wd.findElement(By.linkText("Logout")).click();
				
	}
	@AfterTest
	public void closeBrswr() throws Exception
	{
		Thread.sleep(2000);
		wd.close();
	}

}