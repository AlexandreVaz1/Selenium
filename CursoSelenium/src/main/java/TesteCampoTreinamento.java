import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// http://wcaquino.me/selenium/componentes.html

public class TesteCampoTreinamento {

	@Test
	public void testeTextFiel() {
		WebDriver driver = new  FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita"); 
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		 		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() {
		WebDriver driver = new  FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste"); 
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
			
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		WebDriver driver = new  FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
//		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
			
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		WebDriver driver = new  FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
//		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
			
		driver.quit();
	}
}
