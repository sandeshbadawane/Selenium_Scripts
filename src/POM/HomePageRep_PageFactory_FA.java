package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class HomePageRep_PageFactory_FA 
{
	WebDriver wd;
	public HomePageRep_PageFactory_FA (WebDriver wd) // Parameterized Constructor of the class
	{
	PageFactory.initElements(wd, this);
	this.wd=wd;
}
	@FindBy(linkText = "Logout") WebElement logoutLink;
	
	public void clkLogout()
	{
		logoutLink.click();
	}
}
