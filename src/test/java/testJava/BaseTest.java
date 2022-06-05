package testJava;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigUtils;
import utilities.ExcelUtil;
import utilities.ScreenshotUtil;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginpage;
	protected ExcelUtil excelutil;
	protected DashboardPage dashboardPage;
	protected ScreenshotUtil screenshottil;
	protected ConfigUtils readProp = new ConfigUtils();

	@BeforeClass
	public void BrowserLaunch() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(readProp.getProp("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void objectInit() {
		loginpage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		excelutil = new ExcelUtil();
		screenshottil = new ScreenshotUtil();
	}
	
	@AfterClass
	public void envDown() {
		driver.quit();
	}

}
