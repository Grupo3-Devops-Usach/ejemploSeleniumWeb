package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");     
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
        driver.findElement(By.linkText("Imágenes")).click();
        driver.findElement(By.linkText("Shopping")).click();
    }

    @Test
    public void shouldAnswerWithTruePhoenix()
    {
        System.out.println("Iniciando Pruebas...");
        driver.navigate().to("https://www.amazon.com");
        WebElement searchbox = driver.findElement(By.name("field-keywords"));
        searchbox.sendKeys("The Phoenix Project");     
        searchbox.submit();
        assertEquals("Amazon.com : The Phoenix Project", driver.getTitle());
    }
}
