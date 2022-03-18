package br.nttdata.pageFactories;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	protected static final int TIMEOUT = 5;
	protected static final int POLLING = 100;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageFactory(WebDriver driver) {
    	
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        Locale.setDefault(Locale.US);
    }

    protected void esperarQueOElementoApareca(By locator) {
    	
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void esperarQueOElementoDesapareca(By locator) {
    	
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void esperarQueOTextoDesapareca(By locator, String text) {
    	
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
    
    protected void preencheCampoPorId(String id_campo, String value) {

		driver.findElement(By.id(id_campo)).sendKeys(value);
	}
    
    protected void moverParaOElemento(WebElement element) {
    	
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
