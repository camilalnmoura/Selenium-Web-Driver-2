import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.junit.Assert;

public class TesteTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")) .sendKeys("Teste de Escrita");
		
		
		//Conferindo campos escritos corretos PS: resultado falho
		driver.findElement(By.id("elementosForm:nome")) .getAttribute("value");
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
			
		driver.quit();
	
		
	}
	
	
	@Test
	public void deveInteragirComTextArea(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:sugestoes")) .sendKeys("teste");
		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")) .getAttribute("value"));
		
		driver.quit();
	}
	
	
	//r�dio button
	
	@Test
	public void deveInteragirComRadioButton(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());		
		driver.quit();
		
		
		
		
	}
	//checkbox
	
	@Test
	public void deveInteragirComCheckBox(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());		
		driver.quit();
		
	}
	//combo
	
	
	@Test
	public void deveInteragirComCombo(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(3);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo" , combo.getFirstSelectedOption().getText());
		driver.quit();
		
	}	
	
	//conferindo as op��es dentro do combo
	
	@Test
	public void deveVerificarValoresCombo(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Opcao Qualquer")) {
				encontrou = true;
				break;
				}
			}
		
		Assert.assertTrue(encontrou);	
		driver.quit();
		}
	//combo multipla escolha
	
	@Test
	public void deveVerificarValoresComboMultiplo(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
				
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		//Desmarcando op��es do combo
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		driver.quit();
	
	
	}
	//Bot�es
	
	@Test
	public void deveInteragirComBotoes(){
		WebDriver driver = new ChromeDriver();
		driver.manage() .window() .setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
		
		
	}
		
}