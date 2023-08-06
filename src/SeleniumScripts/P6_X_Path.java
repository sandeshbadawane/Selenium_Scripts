package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_X_Path {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("		");
		
		//id Locator
				WebElement input= wd.findElement(By.id("autocomplete"));
				input.sendKeys("Id Locator");
				
				//Name Locator
				wd.findElement(By.name("enter-name")).sendKeys("Name Locator");
				//Class Locator
				//linkText
				//wd.findElement(By.linkText("Open Tab")).click();
				//Partial link text
				//wd.findElement(By.partialLinkText("Open T")).click();
		//cssSelector
		//1) tagname#id
			wd.findElement(By.cssSelector("input#autocomplete")).sendKeys("Id Locator");
		//2) tagname[attribute=value of attribute]
			wd.findElement(By.cssSelector("input[value=Hide]")).click();
		//3) tagname.className
		//Xpath
		//a] absoulte xpath
		wd.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[1]/input[2]")).click();
		//b] Relative Xpath
		wd.findElement(By.xpath("//*[@id=\"displayed-text\"]")).sendKeys("Relative XPath");
		
		//tagname[@attribute="value of attribute"]
		System.out.println(wd.findElement(By.xpath("//button[@id='mousehover']")).getText());
		
	}

}
