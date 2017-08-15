package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Componente {
	By by;
	WebDriver driver;
	WebElement element;

	public Componente(By by, WebDriver driver) {
		this.by = by;
		this.driver = driver;
		this.element = driver.findElement(by);

	}

}
