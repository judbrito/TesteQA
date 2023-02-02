package Estrutura;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Organizado.DriverFactory;
import Organizado.Metodos;

public class ApresentacaoPage {

	private Metodos dsl;

	public ApresentacaoPage() {
		dsl = new Metodos();

	}

	// Logar teste 1
	public void setAcesso(String login, String senha) {
		dsl.clica("//*[@id='nav-link-accountList-nav-line-1']");
		dsl.escreva("//*[@id='ap_email']", login);
		dsl.clica("//*[@id='continue']");
		dsl.escreva("//*[@id='ap_password']", senha);
		dsl.clica("//*[@id='signInSubmit']");

	}

	// teste 2
	@SuppressWarnings("unused")
	public void desloga() {
		Apresentacao abrir = new Apresentacao();
		dsl.jsScriptClick("//*[@id='nav-item-signout']/span");

	}

	// teste 3
	public void consultaAlgo(String texto) {

		dsl.escreva("//*[@id='twotabsearchtextbox']", texto);
		dsl.clica("//*[@id='nav-search-submit-button']");

	}

	// teste 5
	public void cepTrue(String texto, String cep) {

		dsl.escreva("//*[@id='twotabsearchtextbox']", texto);
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index=\"2\"]//*[@class='a-size-base-plus a-color-base a-text-normal']");
		dsl.clica("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
		dsl.escreva("//*[@id='GLUXZipUpdateInput_0']", cep);
		dsl.jsScriptClick("//*[@id='GLUXZipUpdate']/span/input");

	}
	// teste 6
		public void cepFalse(String texto, String cep) {

			dsl.escreva("//*[@id='twotabsearchtextbox']", texto);
			dsl.clica("//*[@id='nav-search-submit-button']");
			dsl.clica("//*[@data-index='2']//h2//span");
			dsl.clica("//*[@id='contextualIngressPtLabel_deliveryShortLine']");
			dsl.escreva("//*[@id='GLUXZipUpdateInput_0']", cep);
			dsl.jsScriptClick("//*[@id='GLUXZipUpdate-announce']");
		}

	// teste 7
	public void inserePedido() {
		consultaAlgo("console");
		dsl.clica("//*[@data-index='2']//*[contains(text(),'Console')]");
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.clica("//*[@id='nav-cart']");
	}

	// test 8
	@SuppressWarnings("unused")
	public void AddItens() {

		WebElement custo = dsl.elemento("//span[@id='sc-subtotal-amount-buybox']/span");

		String umItem = custo.getText();
		System.out.println("Valor unitário " + umItem);

		WebElement element = dsl.elemento("//*[@id='quantity']");
		Select itens = new Select(element);
		itens.selectByValue("2");
		dsl.time();
		WebElement ver = dsl.elemento("//span[@id='sc-subtotal-amount-buybox']/span");
		String doisItens = ver.getText();

	}

	// test 9
	public void doisItens() {
		// foga
		dsl.escreva("//*[@id='twotabsearchtextbox']", "fogão");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='1' ]//h2//a/span");
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.propaganda();
	
		dsl.time();
		// gela
		dsl.escreva("//*[@id='twotabsearchtextbox']", "geladeira");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='2']//img");
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.jsScriptClick("//*[@class='a-button-text']//..//a");
		dsl.time();
	}

	// test 10
	public void excluiItens() {

		dsl.time();

		dsl.jsScriptClick("//*[@value='Excluir']");

	}

	// test 11
	public void excluiUmItem() {

		dsl.clica("//*[@value='Excluir']//..//input");
		dsl.jsScriptClick("//*[@id='sc-active-cart']//*[@class='a-declarative']//.");

	}

	// test 12
	public void vaiLogar() {
		
		dsl.escreva("//*[@id='twotabsearchtextbox']","televisão");
		dsl.clica("//*[@id='nav-search-submit-button']");
		dsl.clica("//*[@data-index='2']//*[contains(text(),'Televisão') or contains(text(),'Monitor')]");
		dsl.propaganda();
		dsl.time();
		dsl.clica("//*[@id='add-to-cart-button']");
		dsl.clica("//*[@id='nav-cart']");
		dsl.clica("//*[@class='a-button-input']");
	}

	// teste 13
	public void tecnologia() {
		dsl.clica("//*[@class='hm-icon-label']");
		dsl.jsScriptClick("//*[@class='nav-sprite hmenu-arrow-more']//..//div");
		dsl.time();
		dsl.jsScriptClick("//*[@class='hmenu-item']//*[contains(text(),'Computadores e Informática')]");
		dsl.clica("//*[@id='hmenu-close-menu']/../..//*//*[contains(text(),'Notebooks')]");

	}

	// teste 14
	public void tecAlvo() {
		dsl.jsScriptClick("//*[contains(text(),'Marca')]/../..//i");

	}

	// teste 15
	@SuppressWarnings("unused")
	public void organizar() {
		dsl.elemento("//*[contains(text(),'Marca')]/../..//i//.").click();
		WebElement element = dsl.elemento("//*[@id='s-result-sort-select']");
		Select itens = new Select(element);
		itens.selectByVisibleText("Preço: alto a baixo");
		dsl.time();
		WebElement menorPreco = dsl.elemento("//*[contains(text(),'Mais')]//..//../../..//*[contains(text(),'até')]");
		WebElement maiorPreco = dsl.elemento("//*[contains(text(),'WUXGA')]//..//../../..//*[contains(text(),'até')]");
		List<WebElement> lista = new ArrayList<WebElement>();
		lista.add(maiorPreco);
		for (int i = 0; i < lista.size(); i++) {
			if (i == 0 || i == 1) {
				lista.get(i).getText();
			}
		}
	}

// valida 01 
	public void validaUm() {

		if (DriverFactory.getDriver().getTitle().isEmpty()) {
			Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", DriverFactory.getDriver().getTitle());
			Assert.assertEquals("Acessar Amazon", DriverFactory.getDriver().getTitle());

		}
	}

	// valida 02
	public void validaDois(WebDriver driver) {
		Assert.assertTrue("Fazer login",
				dsl.validaTrue("//*[@class='a-box-inner a-padding-extra-large']//h1", "Fazer login"));
		System.out.println(driver.getTitle());
	}

	// valida 03
	public void validaTres() {
		Assert.assertTrue("Bicicleta", dsl.validaTrue("//*[contains(text(),'Bicicleta')]", "Bicicleta"));
	}
	// valida 4

	public void validaQuatro() {
	Assert.assertTrue("Nenhum resultado para",
			dsl.validaTrue("//*[contains(text(),'Nenhum resultado para ')]", "Nenhum resultado para"));
	}
	// validar 5
	public void validaCinco() {
		WebElement visivel = dsl.elemento("//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']");
		assertNotNull(visivel);
		System.out.println(visivel.getText());

	}

	

	// validar 6
	public void validaSeis() {
		WebElement visivel = dsl.elemento("//*[@id='GLUXZipError']/div/div/div");
		System.out.println(visivel.getText());
		assertFalse("Insira um CEP válido",
				dsl.validaTrue("//*[@id='GLUXZipError']/div/div/div", "Insira um CEP válido"));

	}

	// valida 7
	public void validaSete() {
		Assert.assertTrue("Console", dsl.validaTrue("//*[@class='a-truncate-cut']", "Console"));
	}

	// valida 8
	@SuppressWarnings("unused")
	public void validaOito() {
		WebElement custo = dsl.elemento("//span[@id='sc-subtotal-amount-buybox']/span");
		String umItem = custo.getText();

		WebElement ver = dsl.elemento("//span[@id='sc-subtotal-amount-buybox']/span");
		String doisItens = ver.getText();
	}

	// valida 9
	public void validaNove() {
		Assert.assertTrue("2", dsl.validaTrue("//*[@id='nav-cart-count']//.", "2"));
	}

	// valida 10
	public void validaDez() {
		Assert.assertTrue("foi removido de Carrinho de compras.", dsl.validaTrue(
				"//*[text()='foi removido de Carrinho de compras.']", "foi removido de Carrinho de compras."));
	}

	// valida 11
	public void validadoOnze() {
		Assert.assertTrue("1", dsl.validaTrue("//*[@id='nav-cart-count']", "1"));
	}

	// valida 12
	public void validadoDoze() {
		Assert.assertTrue("Fazer login", dsl.validaTrue("//*[@class='a-spacing-small']", "Fazer login"));
	}

	// valida 13
	public void validaTreze() {

		dsl.visivel("//*[@class='a-section octopus-pc-asin-title-review-section']//*[contains(text(),'Note')]");

	}

	// valida 13
	public void validaQuatorze() {
		dsl.invalido("//*[contains(text(),'Marca')]/../..//i");
	}

	// valida 15
	public void validaQuinze() {
		WebElement menorPreco = dsl.elemento("//*[contains(text(),'Mais')]//..//../../..//*[contains(text(),'até')]");
		WebElement maiorPreco = dsl.elemento("//*[contains(text(),'WUXGA')]//..//../../..//*[contains(text(),'até')]");
		Assert.assertTrue(maiorPreco != menorPreco);
		System.out.println("Valor mais alto dobrado: " + maiorPreco.getText());
	}
}
