package br.nttdata.pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import exceptions.HomePageException;

public class HomePageFactory extends BasePageFactory{

	public HomePageFactory(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'SPECIAL OFFER')]")
	WebElement btnSpecialOffer;
	
	@FindBy(xpath="//button[@id='see_offer_btn']")
	WebElement btnSeeOffer;
	
	public void clicarEmSpecialOffer() {
		
		btnSpecialOffer.click();
	}
	
	public void clicarEmSeeOffer() {
		
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Actions actions = new Actions(driver);
		actions.moveToElement(btnSeeOffer).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(btnSeeOffer)).click();
	}

	

	
	
	

}
