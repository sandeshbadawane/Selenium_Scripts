package SeleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_Navigate_Commands {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Java_Selenium_Automation\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		// used to maximize single opened browser instance
		wd.manage().window().maximize();
		// To navigate to the application URL. used to move backward & forward on web page. Works fast compare to get method
		//
		wd.navigate().to("https://www.selenium.dev/");
		Thread.sleep(1000);
		//navigate().back():- To navigate on the previous page
		wd.navigate().back();
		Thread.sleep(1000);
		//navigate().forward():- To navigate on the next page
		wd.navigate().forward();
		Thread.sleep(1000);
		//navigate().refresh():- To reload the  page
		wd.navigate().refresh();
	

	}

}
