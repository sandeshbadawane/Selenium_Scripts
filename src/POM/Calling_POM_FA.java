package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calling_POM_FA {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
//		WebDriver wd = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver wd = new ChromeDriver(options);
		wd.manage().window().maximize();
		
		wd.get("http://demo.frontaccounting.eu/");
		
		LoginPageRepository_FA l=new LoginPageRepository_FA(wd);
		l.setuname("demouser");
		l.setpasswd("password");
		l.clicklogin();
		
		//HomePageRepository_FA o=new HomePageRepository_FA(wd); //using By class POM methods
		//o.clicklogout();
		
		HomePageRep_PageFactory_FA p=new HomePageRep_PageFactory_FA(wd); // using PageFactory POM methods
		p.clkLogout();
		
		//wd.close();
	}

}
