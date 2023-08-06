package POM;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageRepository_FA 
{
	//Webelements repository
	WebDriver wd;
	public LoginPageRepository_FA(WebDriver wd) // Parametrized Constructor of the class
	{
		this.wd=wd;
	}
	
	By uname=By.name("user_name_entry_field");
	By passwd=By.name("password");
	By loginBtn=By.name("SubmitUser");
	
	//Methods
	public void setuname(String un) throws InterruptedException 
	{
		
		wd.findElement(uname).clear();
		Thread.sleep(2000);
		wd.findElement(uname).sendKeys(un);
	}
	public void setpasswd(String pwd) throws InterruptedException 
	{
		wd.findElement(passwd).clear();
		Thread.sleep(2000);
		wd.findElement(passwd).sendKeys(pwd);
	}
	public void clicklogin() 
	{
		wd.findElement(loginBtn).click();
	}
}
