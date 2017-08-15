package fluxo;

import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;

public class Login {
	LoginPage loginPage;

	public Login(WebDriver driver) {
		this.loginPage = new LoginPage(driver);
	}

	public void logar() {
		this.loginPage.login().preencherCampo("wendelhenke@gmail.com");
		this.loginPage.senha().preencherCampo("Pm8jJm");
		this.loginPage.entrar().clicar();
	}

}
