package br.nttdata.steps;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.spi.MonetaryCurrenciesSingletonSpi;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import br.ce.entidades.Filme;
import br.ce.entidades.TipoAluguel;
import br.nttdata.pageFactories.HomePageFactory;
import br.nttdata.pageFactories.ProdutoPageFactory;
import br.nttdata.pageFactories.ShoppingCartPageFactory;
import br.nttdata.getRequest.Data;
import br.nttdata.pageFactories.CheckoutFactory;
import br.nttdata.tests.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProdutoSteps extends BaseTest {
	
	private static final double DELTA = 1e-15;
	
	HomePageFactory homePageFactory = new HomePageFactory(driver);
	ProdutoPageFactory produtoPageFactory = new ProdutoPageFactory(driver);
	CheckoutFactory checkoutFactory = new CheckoutFactory(driver);
	ShoppingCartPageFactory shoppingCartPageFactory = new ShoppingCartPageFactory(driver);
	
	Data dados = new Data();


	@Dado("que acessei o site AdvantageOnlineShopping")
	public void que_acessei_o_site_advantage_online_shopping() {
				
		driver.get("https://advantageonlineshopping.com");
	}

	@E("no menu clicar na opção Special Offer")
	public void no_menu_clicar_na_opção_special_offer() throws InterruptedException {
		homePageFactory.clicarEmSpecialOffer();
		Thread.sleep(2000);
	}

	@E("clicar no botão See Offer")
	public void clicarNoBotãoSeeOffer() throws InterruptedException {
		
		Thread.sleep(2000);
		homePageFactory.clicarEmSeeOffer();
		Thread.sleep(2000);
	}
	
	@Então("vou validar as especificações do produto")
	public void vou_validar_as_especificações_do_produto() {
		
		Map<String, String> valores = dados.validaCampos();
		
//		public void iterateUsingEntrySet(Map<String, Integer> map) {
//		    for (Map.Entry<String, Integer> entry : map.entrySet()) {
//		        System.out.println(entry.getKey() + ":" + entry.getValue());
//		    }
//		}
		
		for(Map.Entry<String, String> entry : valores.entrySet()) {
			Assert.assertEquals(entry.getValue(), produtoPageFactory.extraiConteudoCampo(entry.getKey()));
		}
		
//		List<String> listaCampos = List.of("nomeProduto", "customizacao", "display","displayResolution","displaySize","memoria",
//				"operatingSystem","processor","touchScreen","weigth");
//		
//		listaCampos.forEach(item -> {
//			Assert.assertEquals(valores.get(item), item);
//		});
		
//		List<String> listaEsperada = List.of("HP PAVILION 15Z TOUCH LAPTOP","Simplicity",
//				"15.6-inch diagonal Full HD WLED-backlit Display (1920x1080) Touchscreen","1920x1080","15.6","16GB DDR3 - 2 DIMM",
//				"Windows 10","AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics","Yes","5.51 lb");
//		for(int i = 0; i < 10; i++) {
//			Assert.assertEquals(listaEsperada.get(i), produtoPageFactory.extraiConteudoCampo(listaCampos.get(i)));
//		}
	}
	
	public String alterandoCor = "PURPLE";

	@E("alterar a cor")
	public void alterar_a_cor_do_produto() throws InterruptedException {
		produtoPageFactory.selecionaCorProduto(alterandoCor);
		Thread.sleep(2);
	}
	
	@E("clicar no botão Add to cart")
	public void clicarNoBotãoAddToCart() {
		produtoPageFactory.clicarEmAddCart();
	}

	@Então("o produto foi adicionado ao carrinho")
	public void o_produto_foi_adicionado_ao_carrinho() {
		Assert.assertEquals((produtoPageFactory.validarProdutoAdicionado("txtQtyCarrinho")), "1");
	}

	@E("pesquisar o produto clicando no ícone de lupa")
	public void pesquisar_o_produto_clicando_no_ícone_de_lupa() {
		
		checkoutFactory.pesquisarProduto();
	}

	@E("selecionar o produto pesquisado")
	public void selecionar_o_produto_pesquisado() {
		
		checkoutFactory.selecionarProduto();
	}

	@E("alterar a quantidade de produtos")
	public void alterar_a_quantidade_de_produtos() {
		
		checkoutFactory.excluirItem();
	}


	@E("acessar a página de checkout")
	public void acessar_a_página_de_checkout() {
		
		checkoutFactory.clicarBotaoCheckout();
	}

	@Então("vou validar que a soma dos preços corresponde ao total da página de checkout")
	public void vou_validar_que_a_soma_dos_preços_corresponde_ao_total_da_página_de_checkout() throws InterruptedException {
		 double valorUnitario = Double.parseDouble(checkoutFactory.valorUnitario().substring(1,7));
		 int quantidadeNoTotal = Integer.parseInt(checkoutFactory.quantidade().substring(1,2));
		 
		 double valorTotal = Double.parseDouble(checkoutFactory.valorTotal().substring(1,7));
		Thread.sleep(3000);
		Assert.assertEquals(valorTotal, quantidadeNoTotal * valorUnitario ,DELTA);
	}
	
	@Então("vou realizar um update no banco para a cor escolhida")
	public void realizar_um_update_no_banco_para_a_cor_escolhida() throws InterruptedException {
		
		dados.atualizaCor(alterandoCor);
		Thread.sleep(2000);
	}
	
	@E("clicar no carrinho de compras")
	public void clicarNoCarrinhoDeCompras() {
		produtoPageFactory.clicarNoCarrinho();
	}

	@Quando("remover o produto do carrinho de compras")
	public void remover_o_produto_do_carrinho_de_compras() throws InterruptedException {
		
		Thread.sleep(4000);
		shoppingCartPageFactory.esvaziarCarrinho();
	}

	@Então("o carinho de compras estará vazio")
	public void o_carinho_de_compras_estará_vazio() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//a[@id='shoppingCartLink']//*[name()='svg']"));
		Thread.sleep(4000);
		shoppingCartPageFactory.pausarMouseSobreCarrinhoDeCompras();
		Assert.assertEquals("Your shopping cart is empty", shoppingCartPageFactory.msgCarrinhoVazio());
	}
}
