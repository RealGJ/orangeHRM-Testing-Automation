package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testJava.BaseTest;

public class DashboardPage extends BaseTest {

	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashboardElem;
	
	@FindBy (id = "welcome") WebElement welcomeElem;
	
	@FindBy (xpath = "//a[text()='Logout']") WebElement logoutBtn;
	
	@FindBy(id = "menu_admin_viewAdminModule") WebElement adminBtn;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLogin() {
		if (dashboardElem.getText().equals("Dashboard"))
			return true;
		else
			return false;
	}
	
	public void gotoAdminModule() {
		adminBtn.click();
	}
	
	public void logoutMethod() {
		welcomeElem.click();
		logoutBtn.click();
	}

}
