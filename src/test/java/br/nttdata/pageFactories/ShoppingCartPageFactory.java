package br.nttdata.pageFactories;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPageFactory extends BasePageFactory{

	public ShoppingCartPageFactory(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "REMOVE")
	WebElement btnRemoverProduto;
		
	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[1]/div[1]/label[1]")
	WebElement txtCarrinhoVazio;
	
	@FindBy(xpath = "//header/nav[1]/ul[1]/li[2]/ul[1]/li[1]/tool-tip-cart[1]/div[1]/div[1]/label[1]/span[1]")
	WebElement txtQuantidadeVazia;
	
	@FindBy(xpath = "//a[@id='shoppingCartLink']//*[name()='svg']")
	WebElement carrinho;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/label[2]")
	WebElement quantidadeCarrinho;
	
	@FindBy(xpath = "//a[contains(text(),'CONTINUE SHOPPING')]")
	WebElement btnContinueShopping;
	
	@FindBy(xpath = "//header/nav[1]/ul[1]/li[2]/ul[1]/li[1]/tool-tip-cart[1]/div[1]/div[1]/label[2]")
	WebElement mensagemCarrinhoVazio;
	
	@FindBy(xpath = "//a[@id='shoppingCartLink']//span[@class='cart ng-binding'][normalize-space()='3']")
	WebElement numero;
	
	
	public void esvaziarCarrinho() throws InterruptedException {
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnRemoverProduto)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}

	
	public String msgCarrinhoVazio() {
		
		return txtCarrinhoVazio.getText();
	}
	
	
	public String msgQuantidadeVazia() {
		
		return txtQuantidadeVazia.getText();
	}
	
	
	public void pausarMouseSobreCarrinhoDeCompras() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(carrinho).pause(10).build();
	}
	
	
	public void mensagemCarrinhoVazio() {
		mensagemCarrinhoVazio.getText();
	}
}
