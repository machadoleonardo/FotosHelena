package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField extends Componente {

	public TextField(By by, WebDriver driver) {
		super(by, driver);
	}

	public void preencherCampo(String texto) {
		this.element.sendKeys(texto);
	}

	public void limparCampo() {
		this.element.clear();
	}
}
