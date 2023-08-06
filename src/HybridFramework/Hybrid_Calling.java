package HybridFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import Keyword_Driven.Kdf_Repository_FA;

public class Hybrid_Calling {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java_Selenium_automation\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		//		WebDriver wd = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver wd = new ChromeDriver(options);
		wd.manage().window().maximize();

		FileInputStream fi = new FileInputStream("./Hybrid.xlsx");

		XSSFWorkbook wk = new XSSFWorkbook(fi);

		XSSFSheet dsh=wk.getSheet("Credentails"); //for data
		XSSFSheet ksh=wk.getSheet("Keywords");// for keywords
		Hybrid_Repository_FA k=new Hybrid_Repository_FA(wd);

		for (int i=1;i<=dsh.getLastRowNum();i++)
		{
			XSSFRow rw=dsh.getRow(i);
			XSSFCell un=rw.getCell(0);
			String pwd=rw.getCell(1).toString();
			XSSFCell res=rw.createCell(3);   // to write data on cell

			System.out.println(un+" "+pwd);
			try {
				for (int j=1;j<=ksh.getLastRowNum();j++)
				{
					XSSFRow krw=ksh.getRow(j);
					String key=krw.getCell(1).toString();

						System.out.println(key);
					switch(key) 
					{
					case "openBrwsr":
						k.openBrwsr();
						break;
					case "setUname":
						k.setUname(un.toString());
						break;
					case "setPasswd":
						k.setPasswd(pwd.toString());
						break;
					case "clkLoginBtn":
						k.clkLoginBtn();
						break;
					case "clkLogoutLink":
						k.clklLogoutLink();
						break;	

					default:
						System.out.println("Invalid Keyword");
						break;
					}
				} 
				System.out.println("valid credentails\n");
				res.setCellValue("Pass");   // to write data on cell
			}
			catch (Exception e) {
				System.out.println("Invalid credentails");
				TakesScreenshot ts=(TakesScreenshot) wd;
				File s=ts.getScreenshotAs(OutputType.FILE);
				File d=new File("./"+un+".png");
				FileHandler.copy(s, d);
				res.setCellValue("Fail");    // to write data on cell
			}
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("./Hybrid.xlsx"); // To write data on excel cell
		wk.write(fo);    										// To write data on excel cell
		
		Thread.sleep(3000);
		wd.close();
	}
}

