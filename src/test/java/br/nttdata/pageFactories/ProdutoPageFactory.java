package br.nttdata.pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPageFactory extends BasePageFactory {

	public ProdutoPageFactory(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[@class='roboto-regular screen768 ng-binding']")
	WebElement nomeProduto;

	@FindBy(xpath = "//label[normalize-space()='Simplicity']")
	WebElement customizacao;

	@FindBy(xpath = "//label[contains(text(),'15.6-inch diagonal Full HD WLED-backlit Display (1')]")
	WebElement display;

	@FindBy(xpath = "//label[normalize-space()='1920x1080']")
	WebElement displayResolution;

	@FindBy(xpath = "//label[normalize-space()='15.6']")
	WebElement displaySize;

	@FindBy(xpath = "//label[normalize-space()='16GB DDR3 - 2 DIMM']")
	WebElement memoria;

	@FindBy(xpath = "//label[normalize-space()='Windows 10']")
	WebElement operatingSystem;

	@FindBy(xpath = "//label[contains(text(),'AMD Quad-Core A10-8700P Processor + AMD Radeon(TM)')]")
	WebElement processor;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement touchscreen;

	@FindBy(xpath = "//label[normalize-space()='5.51 lb']")
	WebElement weight;

	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[3]")
	WebElement color;

	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[4]")
	WebElement corRoxa;

	@FindBy(xpath = "//body/div[3]/section[1]/article[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span[5]")
	WebElement corVermelha;
	
	@FindBy(xpath = "//button[@name='save_to_cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//a[@id='shoppingCartLink']//span[@class='cart ng-binding'][normalize-space()='1']")
	WebElement txtQtyCarrinho;
	
	@FindBy(xpath = "//label[normalize-space()='QTY: 1']")
	WebElement txtQty;
	
	@FindBy(xpath = "//a[@id='shoppingCartLink']//*[name()='svg']")
	WebElement btnCarrinho;
	

	public String extraiConteudoCampo(String itemName) {
		
		switch (itemName) {
		case "nameProduct": {
			return nomeProduto.getText();
		}
		case "customization": {
			return customizacao.getText();
		}
		case "display": {
			return display.getText();
		}
		case "displayResolution": {
			return displayResolution.getText();
		}
		case "displaySize": {
			return displaySize.getText();
		}
		case "memory": {
			return memoria.getText();
		}
		case "operatingSystem": {
			return operatingSystem.getText();
		}
		case "processor": {
			return processor.getText();
		}
		case "touchscreen": {
			return touchscreen.getText();
		}
		case "weight": {
			return weight.getText();
		}
		case "color": {
			return color.getAttribute("title").toString();
		}
		default: {
			return null;
		}
		}
	}
	

	public void selecionaCorProduto(String cor) {
		
		switch (cor) {
		case "GRAY": {
			color.click();
		}
		case "PURPLE": {
			corRoxa.click();
		}
		case "RED": {
			corVermelha.click();
		}
		}
	}
	
	
	public void clicarEmAddCart() {
		btnAddToCart.click();
	}
	
	public String validarProdutoAdicionado(String valor) {
	
		if(valor.equals("txtQtyCarrinho")) {
			return txtQtyCarrinho.getText();
		} 
		else if (valor.equals("txtQty")){
			return txtQty.getText();
		} 
		return "";
	}
	
	
	public void clicarNoCarrinho() {
		
		btnCarrinho.click();
	}

}
