package br.nttdata.steps;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.nttdata.pageFactories.CheckoutFactory;
import br.nttdata.pageFactories.HomePageFactory;
import br.nttdata.pageFactories.ProdutoPageFactory;
import br.nttdata.pageFactories.ShoppingCartPageFactory;
import br.nttdata.restAssured.Data;
import br.nttdata.tests.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ProdutoSteps extends BaseTest {
	
	private static final double DELTA = 1e-15;
	
	private static int i;
	
	HomePageFactory homePageFactory = new HomePageFactory(driver);
	ProdutoPageFactory produtoPageFactory = new ProdutoPageFactory(driver);
	CheckoutFactory checkoutFactory = new CheckoutFactory(driver);
	ShoppingCartPageFactory shoppingCartPageFactory = new ShoppingCartPageFactory(driver);
	
	Data dados = new Data();
	public static String alterandoCor = "PURPLE";


	@Dado("que acessei o site AdvantageOnlineShopping")
	public void que_acessei_o_site_advantage_online_shopping() throws Exception {
				
		driver.get("https://advantageonlineshopping.com");
	}

	@E("no menu clicar na opção Special Offer")
	public void no_menu_clicar_na_opção_special_offer() throws Exception {
		
		homePageFactory.clicarEmSpecialOffer();
		takeSnapShot(driver,"target/screenshoots/" + i++ +".jpg");
		Thread.sleep(2000);
	}

	@E("clicar no botão See Offer")
	public void clicarNoBotãoSeeOffer() throws Exception {
		
		Thread.sleep(2000);
		homePageFactory.clicarEmSeeOffer();
		Thread.sleep(2000);
		takeSnapShot(driver,"target/screenshoots/" + i++ +".jpg");

	}
	
	@Então("vou validar as especificações do produto")
	public void vou_validar_as_especificações_do_produto() {
		
		Map<String, String> valores = dados.validaCampos();
		
		for(Map.Entry<String, String> entry : valores.entrySet()) {
			Assert.assertEquals(entry.getValue(), produtoPageFactory.extraiConteudoCampo(entry.getKey()));
		}
	}
	
	@E("alterar a cor")
	public void alterar_a_cor_do_produto() throws Exception {
		
		produtoPageFactory.selecionaCorProduto(alterandoCor);
		Thread.sleep(2);
	}
	
	@E("clicar no botão Add to cart")
	public void clicarNoBotãoAddToCart() {
		
		produtoPageFactory.clicarEmAddCart();
	}

	@Então("o produto foi adicionado ao carrinho")
	public void o_produto_foi_adicionado_ao_carrinho() throws Exception {
		
		Assert.assertEquals((produtoPageFactory.validarProdutoAdicionado("txtQtyCarrinho")), "1");
		takeSnapShot(driver,"target/screenshoots/" + i++ +".jpg");

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
	public void o_carinho_de_compras_estará_vazio() throws Exception {

		WebElement element = driver.findElement(By.xpath("//a[@id='shoppingCartLink']//*[name()='svg']"));
		Thread.sleep(4000);
		shoppingCartPageFactory.pausarMouseSobreCarrinhoDeCompras();
		Assert.assertEquals("Your shopping cart is empty", shoppingCartPageFactory.msgCarrinhoVazio());

	}
}
