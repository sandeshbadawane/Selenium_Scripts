package SeleniumScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P15_MultiWindow_Handling 
	{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("http://demo.frontaccounting.eu/");
		Thread.sleep(2000);
		wd.findElement(By.name("user_name_entry_field")).sendKeys("demouser");
		wd.findElement(By.name("password")).clear();
		wd.findElement(By.name("password")).sendKeys("password");
		wd.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		wd.findElement(By.linkText("Sales Quotation Entry")).click();
		String pid=wd.getWindowHandle();
		System.out.println(pid);
		wd.findElement(By.linkText("-1,031,442.24")).click();
		Set <String> allwin=wd.getWindowHandles();
		for (String w : allwin)
		{
		wd.switchTo().window(w);
		if(!(w.equals(pid)))
		{
		Select sel=new Select(wd.findElement(By.id("customer_id")));
		sel.selectByVisibleText("ABC");
		wd.findElement(By.xpath("//*[@id=\"RefreshInquiry\"]/span"));
		wd.close();
		wd.switchTo().window(pid);

		}

		System.out.println(wd.getTitle());
		}
		Thread.sleep(3000);
		wd.quit();
		}

		

	}


