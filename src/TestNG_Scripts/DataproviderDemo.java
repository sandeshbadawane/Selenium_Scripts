package TestNG_Scripts;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataproviderDemo {
  @Test(dataProvider = "dp")
  public void f(String n, String s) 
  {
	  System.out.println(n+"\t"+s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "X", "a" },
      new Object[] { "Y", "b" },
      new Object[] { "Z", "b" },
    };
  }
}
