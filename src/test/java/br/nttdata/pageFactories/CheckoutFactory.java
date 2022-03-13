package br.nttdata.pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFactory extends BasePageFactory {

	public CheckoutFactory(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='SEARCH']//*[name()='svg']")
	WebElement btnLupa;
	
	@FindBy(xpath = "//input[@id='autoComplete']")
	WebElement nomeProduto;
	
	@FindBy(xpath = "//a[contains(text(),'View All')]")
	WebElement btnViewAll;
	
	@FindBy(xpath = "//a[contains(text(),'HP Pavilion 15z Touch Laptop')]")
	WebElement produtoEncontrado;
	
	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[2]/e-sec-plus-minus[1]/div[1]/div[3]")
	WebElement btnAumentarQuantidade;
	
	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[2]/e-sec-plus-minus[1]/div[1]/div[1]")
	WebElement btnDiminuirQuantidade;
	
	@FindBy(xpath = "//button[@id='checkOutPopUp']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//body/div[@class='uiview ng-scope']/section[@class='ng-scope']/article[contains(@class,'max-width')]/div[@id='product_2']/div[@id='Description']/h2[1]")
	WebElement precoUnitarioElement;
	
	@FindBy(xpath = "//label[@class='roboto-regular ng-binding']")
	WebElement quantidadeSelecionada;
	
	@FindBy(xpath = "//span[@class='roboto-medium totalValue ng-binding']")
	WebElement valorTotalTag;
	
	
	public void pesquisarProduto() {
		
		btnLupa.click();
		nomeProduto.sendKeys("HP PAVILION 15Z TOUCH LAPTOP");
	}
	
	public void selecionarProduto() {
		
		btnViewAll.click();
		produtoEncontrado.click();
	}
	
	public void incluirItem() {
		
		btnAumentarQuantidade.click();
	}
	
	public void excluirItem() {
		
		btnDiminuirQuantidade.click();
	}
	
	public void clicarBotaoCheckout() {
		
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
	}
	
	public String valorUnitario() {
		
		return precoUnitarioElement.getText();
	}
	
	public String quantidade() {
		
		return quantidadeSelecionada.getText();
	}
	
	public String valorTotal() { 
		
		return valorTotalTag.getText();
	}

}
