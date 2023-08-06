package SeleniumScripts;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P14_Iframe_Scroll_Handeling {

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		Thread.sleep(2000);
		// 1. Switch to frame --> by index
		//	wd.switchTo().frame(0);
		
		// 2. Switch to frame --> by id or name
		//wd.switchTo().frame("courses-iframe"); //by id
		//wd.switchTo().frame("iframe-name"); //by name
		
		// 3. Switch to frame --> by web element
		
		JavascriptExecutor js =(JavascriptExecutor)wd;
		
		WebElement frame = wd.findElement(By.xpath("//*[@id=\"courses-iframe\"]"));
		
		//by element
		js.executeScript("arguments[0].scrollIntoView();",frame);
		
		//by pixel
		//Point p= frame.getLocation();
		//int x = p.getX();
		//int y =p.getY();
		//js.executeScript("argument [0].scrollIntoView()",frame);
		//js.executeScript("window.scrollBy("+x+","+y+")");
		
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//scroll mouse wheel
		//Robot r =new Robot();
		//r.mouseWheel(15);
		wd.switchTo().frame(frame);
		Thread.sleep(2000);
		System.out.println(wd.findElement(By.linkText("Practice")).getText());
		//Switch frame to parent or default
		//wd.switchTo().parentFrame();
		wd.switchTo().defaultContent();
				
		wd.findElement(By.id("mousehover")).click();
		List<WebElement> fr= wd.findElements(By.tagName(""));
	}

}
