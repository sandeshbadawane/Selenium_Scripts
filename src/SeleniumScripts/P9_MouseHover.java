package SeleniumScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class P9_MouseHover {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		//Fluent Wait
//		Wait<WebDriver> wt= new FluentWait<WebDriver>(wd)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2));
		//	Explicit Wait
//old syntax	WebDriverWait wt = new WebDriverWait(wd, 10);
//new syntax	WebDriverWait wt = new WebDriverWait(wd, Duration.ofSeconds(10));
		//Implicit wait
		/* old syntax */	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//new syntax	    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wd.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
//	wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));	
		wd.findElement(By.name("username")).sendKeys("Admin");
		wd.findElement(By.name("password")).sendKeys("admin123");
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Actions act = new Actions(wd);
//		act.moveToElement(wd.findElement(By.linkText("Admin"))).perform();
		
		List<WebElement> menus = wd.findElements(By.className("oxd-main-menu-item"));
		System.out.println("Size of list- " +menus.size());
		
		WebElement f= menus.get(0);
//		System.out.println("1st elet - "+f.getText());
//		System.out.println("Last element -"+menus.get(menus.size()-1).getText());
		System.out.println("Menu list");
		/*using for loop
		 * for (int i = 0; i < menus.size(); i++) {
		 * System.out.println(menus.get(i).getText()); }
		 */
		//using for each
		for (WebElement m : menus) 
		{
			System.out.println(m.getText());
			Thread.sleep(1000);
			//to perform mousehover on all menus
			act.moveToElement(m).perform();
		}
		
		
	}

}
