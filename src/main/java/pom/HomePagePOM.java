package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	public WebDriver driver;

	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "login-button")
	public WebElement loginbutton;

	public void enterUsername(String username) {
		userName.clear();
		userName.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginbutton.click();
	}
}
