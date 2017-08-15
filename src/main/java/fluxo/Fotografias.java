package fluxo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Fotografias {
	WebDriver driver;
	Login login;

	public Fotografias(WebDriver driver) {
		this.driver = driver;
		this.driver.get("http://www.selpics.com/selecao/login/268053");
		this.login = new Login(driver);

	}

	public void logar() {
		this.login.logar();
	}

	private List<WebElement> fotografias() {
		return this.driver.findElements(By.className("grid-item "));
	}

	public void salvarFotografiasMiniaturas() throws IOException {
		int numeroFoto = 0;
		String path = "/home/leonardo/FotosHelena/";
		StringSelection stringSelection;
		Clipboard clipboard;
		try {
			Robot robot = new Robot();

			for (WebElement element : this.fotografias()) {
				numeroFoto++;
				element.findElement(By.tagName("a"));
				String linkAmostra = element.findElement(By.tagName("a")).getAttribute("href");
				String linkMiniatura = element.findElement(By.tagName("img")).getAttribute("data-original");
				((JavascriptExecutor) this.driver).executeScript("window.open()");

				ArrayList<String> tabs = new ArrayList<String>(this.driver.getWindowHandles());
				this.driver.switchTo().window(tabs.get(1)); // switches to new tab
				this.driver.get(linkMiniatura);
				new Actions(this.driver).sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_S);
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_A);
				String miniatura = path + numeroFoto + "_miniatura.jpg";
				stringSelection = new StringSelection(miniatura);
				clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				// 2nd Robot to my avail
				robot = new Robot();

				// presses Enter
				robot.keyPress(KeyEvent.VK_ENTER); // press Enter
				robot.keyRelease(KeyEvent.VK_ENTER); // release Enter
				this.driver.get(linkAmostra);
				new Actions(this.driver).sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_S);
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_A);
				String amostra = path + numeroFoto + "_amostra.jpg";
				stringSelection = new StringSelection(amostra);
				clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, stringSelection);
				robot = new Robot();

				// presses Enter
				robot.keyPress(KeyEvent.VK_ENTER); // press Enter
				robot.keyRelease(KeyEvent.VK_ENTER); // release Ent
				this.driver.close();
				this.driver.switchTo().window(tabs.get(0));

			}

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
