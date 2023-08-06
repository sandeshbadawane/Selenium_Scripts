package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageRepository_FA 
{
	WebDriver wd;
	public HomePageRepository_FA(WebDriver wd) // Parameterized Constructor of the class
	{
		this.wd=wd;
	}
	//Webelements repository
	
	By logout=By.linkText("Logout");
	
	//Methods
	public void clicklogout() 
	{
		wd.findElement(logout).click();
	}
}
