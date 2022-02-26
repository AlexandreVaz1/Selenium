import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// http://wcaquino.me/selenium/componentes.html

public class TesteCampoTreinamento {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		driver = new  FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void testeTextFiel(){
		dsl.escrever("elementosForm:nome", "Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void testTextFieldDuplo() {
		dsl.escrever("elementosForm:nome", "Alexandre");
		Assert.assertEquals("Alexandre", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escrever("elementosForm:nome", "Vaz");
		Assert.assertEquals("Vaz", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escrever("elementosForm:sugestoes", "teste");
		Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0"));
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:0"));
	}
	
	@Test
	public void deveInteragirComCombo(){
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", dsl.obterValorCombo("elementosForm:escolaridade"));
	}

	@Test
	public void deveVerificarValoresCombo(){
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm: esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
	}
	
	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}

	@Test
	public void deveBuscarTextosNaPagina1() {
// 		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas.. .",dsl.obterTexto(By.className("facilAchar")));
	}
	
//	@Test
//	public void deveInteragirComAlertConfirm() {
		
//		driver.findElement(By.id("confirm")).click();
//		Alert alerta = driver.switchTo().alert();
//		Assert.assertEquals("Confirm Simples", alerta.getText());
//		alerta.accept();
//		Assert.assertEquals("Confirmado", alerta.getText());
//		alerta.accept();
		
//		driver.findElement(By.id("confirm")).click();
//		alerta = driver.switchTo().alert();
//		Assert.assertEquals("Confirm Simples", alerta.getText());
//		alerta.dismiss();
//		Assert.assertEquals("Negado", alerta.getText());
//		alerta.dismiss();
//	}
	
//	@Test
//	public void deveInteragirComPrompt() {
		
//		driver.findElement(By.id("prompt")).click();
//		Alert alerta = driver.switchTo().alert();
//		Assert.assertEquals("Digite um numero", alerta.getText());
//		alerta.sendKeys("12");
//		alerta.accept();
//		Assert.assertEquals("Era 12?", alerta.getText());
//		alerta.accept();
//		Assert.assertEquals(":D", alerta.getText());
//		alerta.accept();
//	}
}










