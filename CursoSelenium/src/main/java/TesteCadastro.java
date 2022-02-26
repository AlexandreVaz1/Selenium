import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new  FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");			
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
		
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		dsl.escrever("elementosForm:nome", "Alexandre");
		dsl.escrever("elementosForm:sobrenome", "Vaz");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Alexandre")); 
		Assert.assertEquals("Sobrenome: Vaz", dsl.obterTexto("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
		Assert.assertEquals("Comida: Carne", dsl.obterTexto("descComida"));
		Assert.assertEquals("Escolaridade: superior", dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Esportes: Corrida", dsl.obterTexto("descEsportes"));
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		dsl.clicarBotao("elementForm:cadastar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTexto());					
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		dsl.escrever("elementosForm:nome", "Nome Qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTexto());
	}

	@Test
	public void deveValidarSexoObrigatorio() {
		dsl.escrever("elementosFor:nome", "Nome qualquer");
		dsl.escrever("elementosFor:sobrenome", "Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTexto());
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarRadio("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que eh vegeratiano?", dsl.alertaObterTexto());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes", "Karate");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertObterTextoEAceita());
	}	
}


