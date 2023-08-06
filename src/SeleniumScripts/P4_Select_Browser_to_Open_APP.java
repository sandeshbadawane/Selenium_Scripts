package SeleniumScripts;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class P4_Select_Browser_to_Open_APP {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");		
		System.setProperty("webdriver.edge.driver", "D:\\Java_Selenium_automation\\Edge_Driver\\msedgedriver.exe");
		Scanner sc=new Scanner(System.in);
		System.out.println("1-Chrome \n2-Edge");
		System.out.println("Select browser");
		int ch=sc.nextInt();
		WebDriver wd=null;

		switch (ch)
		{
		case 1:
			wd = new ChromeDriver();
			break;
		case 2:
			wd = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid selection");
			break;
		}
		try {
			
		wd.manage().window().maximize();
		wd.get("https://blazedemo.com");
		System.out.println("Title - "+wd.getTitle());
		Thread.sleep(2000);
		wd.close();
			
		} catch (Exception e) 
		{
			System.err.println("Invalid browser selection");
		}
		
//		Another method for handing invalid browser
//		if (wd==null) 
//		{
//			System.out.println("Invalid browser");	
//		} else 
//		{
//			wd.manage().window().maximize();
//		wd.get("https://blazedemo.com");
//		System.out.println("Title - "+wd.getTitle());
//		Thread.sleep(2000);
//		wd.close();
		}
	}

