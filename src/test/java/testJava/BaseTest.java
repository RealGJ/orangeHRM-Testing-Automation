package testJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.ConfigUtils;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginpage;
	protected ConfigUtils readProp = new ConfigUtils();

	@BeforeClass
	public void BrowserLaunch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(readProp.getProp("url"));
	}

	@BeforeMethod
	public void objectInit() {
		loginpage = new LoginPage(driver);
	}
	
	@AfterClass
	public void envDown() {
		driver.quit();
	}

}
