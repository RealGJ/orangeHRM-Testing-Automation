package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testJava.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "txtUsername")
	WebElement usernameBox;

	@FindBy(id = "txtPassword")
	WebElement passwordBox;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//span[text()='Invalid credentials']")
	WebElement invalidCredMsg;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void loginMethod(String usrname, String psw) {
		usernameBox.sendKeys(usrname);
		passwordBox.sendKeys(psw);
		loginBtn.click();
	}

	public boolean getAlert() {
		if (invalidCredMsg.getText().equals("Invalid credentials"))
			return true;
		else
			return false;
	}

}
