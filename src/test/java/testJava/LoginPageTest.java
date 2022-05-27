package testJava;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority = 0)
	public void verifyTitle() {
		Assert.assertEquals(loginpage.getCurrentTitle(), "OrangeHRM");
	}
	
	@Test(priority = 1)
	public void verifyURL() throws Exception {
		Assert.assertEquals(loginpage.getCurrentURL(), readProp.getProp("url"));
	}
	
	@Test(priority = 2)
	public void positiveLogin() throws Exception {
		loginpage.loginMethod(readProp.getProp("username"), readProp.getProp("password"));
		screenshottil.takeScreenshot("positiveLogin", driver);
		
	}
	
	@Test(enabled = false ,priority = 3)
	public void negativeLogin() throws Exception {
		for(int i=0;i<3;i++)
			loginpage.loginMethod(excelutil.readExcel(i, 0), excelutil.readExcel(i, 1));
		Assert.assertEquals(loginpage.getAlert(), true);
	}
	
}
