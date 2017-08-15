package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import components.Button;
import components.TextField;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public TextField login() {
		By by = By.id("login-selecao");
		return new TextField(by, this.driver);
	}

	public TextField senha() {
		By by = By.id("senha-selecao");
		return new TextField(by, this.driver);
	}

	public Button entrar() {
		By by = By.id("bt_login");
		return new Button(by, this.driver);
	}

}
