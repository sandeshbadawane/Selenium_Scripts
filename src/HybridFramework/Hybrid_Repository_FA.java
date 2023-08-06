package HybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hybrid_Repository_FA 
{
	WebDriver wd;
	public Hybrid_Repository_FA (WebDriver wd)
	{
		this.wd=wd;
	}
	
	By uname=By.name("user_name_entry_field");
	By passwd=By.name("password");
	By loginBtn=By.name("SubmitUser");
	By logoutLink=By.linkText("Logout");
	
	public void openBrwsr()
	{
		wd.navigate().to("http://demo.frontaccounting.eu/");
	}
	public void setUname(String un) throws InterruptedException 
	{
		wd.findElement(uname).clear();
		Thread.sleep(2000);
		wd.findElement(uname).sendKeys(un);
	}
	public void setPasswd(String pwd) throws InterruptedException 
	{
		wd.findElement(passwd).clear();
		Thread.sleep(2000);
		wd.findElement(passwd).sendKeys(pwd);	
	}
	public void clkLoginBtn() throws InterruptedException
	{
			Thread.sleep(2000);
		wd.findElement(loginBtn).click();
	}
	public void clklLogoutLink() throws InterruptedException 
	{
			Thread.sleep(2000);
		wd.findElement(logoutLink).click();
	}

}

