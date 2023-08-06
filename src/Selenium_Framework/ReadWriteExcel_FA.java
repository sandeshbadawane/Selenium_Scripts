package Selenium_Framework;

import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;



public class ReadWriteExcel_FA 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
//		WebDriver wd = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver wd = new ChromeDriver(options);
		wd.manage().window().maximize();
				
		FileInputStream fi = new FileInputStream("./DDF.xlsx");

		XSSFWorkbook wk = new XSSFWorkbook(fi);
	//	XSSFSheet sh=wk.getSheetAt(0); // By index
		XSSFSheet sh=wk.getSheet("LoginData_FA");
		
		for (int i=1;i<=sh.getLastRowNum();i++)
		{
		XSSFRow rw=sh.getRow(i);
		XSSFCell un=rw.getCell(0);
		String pwd=rw.getCell(1).toString();
		XSSFCell res=rw.createCell(3);   // to write data on cell
		
		System.out.println(un+" "+pwd);
		
		wd.navigate().to("http://demo.frontaccounting.eu/");
		
		wd.findElement(By.name("user_name_entry_field")).sendKeys(un.toString());
		wd.findElement(By.name("password")).clear();
		wd.findElement(By.name("password")).sendKeys(pwd);
		wd.findElement(By.name("SubmitUser")).click();
		try 
		{
			wd.findElement(By.linkText("Logout")).click();
			System.out.println("Valid Credentails");
			res.setCellValue("Pass");   // to write data on cell
			
		} catch (Exception e) 
		{
			wd.navigate().back();
			Thread.sleep(2000);
			System.out.println("Invalid Credentail");
			TakesScreenshot ts=(TakesScreenshot) wd;
			File s=ts.getScreenshotAs(OutputType.FILE);
			File d=new File("./"+un+".png");
			FileHandler.copy(s, d);
			
			res.setCellValue("Fail");    // to write data on cell
		}
		
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("./DDF.xlsx"); // To write data on excel cell
		wk.write(fo);    										// To write data on excel cell
		
		Thread.sleep(3000);
		wd.close();
	}

}
