package SeleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_DemoScripts {

	public static void main(String[] args) { // Used to open blank instance of web browser
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_Automation\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		// used to maximize single opened browser instance
		wd.manage().window().maximize();
		// get(string URL)- used to open an application url in the current opened
		// instance of web browser
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		// To capture the description or title of open web page
		System.out.println("Page Title- " + wd.getTitle());
//		
//		  String title="Practice Page"; 
//		if(title.equals(wd.getTitle()))
//		 System.out.println("COrrect URL");
//		else System.out.println("Wrong URL");
		  
		 // to capture current open page URL
		System.out.println("Current page url- " + wd.getCurrentUrl());
		//to get page source of current open webpage
		System.out.println("Page Source- " +wd.getPageSource());
		// to close single open instance of web browser
		//wd.close();
		// to close multiple open instance of web browser
		wd.quit();

	}

}
