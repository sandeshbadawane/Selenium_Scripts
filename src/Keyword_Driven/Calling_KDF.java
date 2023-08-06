package Keyword_Driven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calling_KDF 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
//		WebDriver wd = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver wd = new ChromeDriver(options);
		wd.manage().window().maximize();
				
		FileInputStream fi = new FileInputStream("./KDF.xlsx");
		
		XSSFWorkbook wk = new XSSFWorkbook(fi);
		XSSFSheet sh=wk.getSheet("Keywords");
		Kdf_Repository_FA k = new Kdf_Repository_FA(wd)	;
			for (int i=1;i<=sh.getLastRowNum();i++)
			{
			XSSFRow rw=sh.getRow(i);
			String key=rw.getCell(1).toString();
			
	//		System.out.println(key);
			switch(key) 
			{
			case "openBrwsr":
				k.openBrwsr();
				break;
			case "setUname":
				k.setUname("demouser");
				break;
			case "setPasswd":
				k.setPasswd("password");
				break;
			case "clkLoginBtn":
				k.clkLoginBtn();
				break;
			case "clkLogoutLink":
				k.clklLogoutLink();
				break;	
				
			default:
			break;
			}
			
			}
}
}
