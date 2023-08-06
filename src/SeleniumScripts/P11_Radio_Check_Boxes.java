package SeleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.chrome.ChromeDriver;
public class P11_Radio_Check_Boxes {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		// wd.findElement(By.cssSelector("input[value=radio1]")).click();
		// List<WebElement> radioBtn=wd.findElements(By.name("radioButton"));
		// for (WebElement r:radioBtn )
		// {
		// Thread.sleep(1000);
		// r.click();
		// }
		// List<WebElement> ckbox=wd.findElements(By.xpath("//input[@type='checkbox']"));
		// for (WebElement c:ckbox )
		// {
		// Thread.sleep(1000);
		// c.click();
		// }

		//****************To check the methods on WebElement ***********

		//*************isSelected() Method******************

		// boolean st=wd.findElement(By.cssSelector("input[value=radio1]")).isSelected();
		// System.out.println(st);
		// if(st==false)
		// {
		// wd.findElement(By.cssSelector("input[value=radio1]")).click();
		// System.out.println("if block executed");
		// }
		// else
		// {
		// System.out.println("already clicked");
		// }

		//************isDisplayed() Method**********************

		wd.findElement(By.id("hide-textbox")).click(); //Click Hide Button
		WebElement input=wd.findElement(By.id("displayed-text"));
		if(input.isDisplayed()==false)
		{
		wd.findElement(By.id("show-textbox")).click(); //Click On the Show Button
		System.out.println("inside if block");
		}
		input.sendKeys("data"); //type in the Box

		}
		}