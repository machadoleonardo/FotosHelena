package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Componente {

	public Button(By by, WebDriver driver) {
		super(by, driver);
	}

	public void clicar() {
		this.element.click();
	}

}
