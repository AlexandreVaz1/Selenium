import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteGoogle {

	@Test
	public void teste() {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alexandre Vaz\\Desktop\\TESTES FUNCIONAIS COM SELENIUM WEBDRIVER\\DRIVERS\\geckodriver.exe");
// 		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexandre Vaz\\Desktop\\TESTES FUNCIONAIS COM SELENIUM WEBDRIVER\\DRIVERS\\chromedriver.exe");			
//		WebDriver driver = new  FirefoxDriver();
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");	
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
}
