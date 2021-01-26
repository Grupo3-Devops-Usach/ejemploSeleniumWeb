package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

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
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        searchbox.sendKeys("HandBook Devops");  
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
        driver.findElement(By.linkText("Imágenes")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Shopping")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void shouldAnswerWithTruePhoenix()
    {
        System.out.println("Iniciando Pruebas...");
        driver.navigate().to("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchbox = driver.findElement(By.name("field-keywords"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        searchbox.sendKeys("The Phoenix Project");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertEquals("Amazon.com : The Phoenix Project", driver.getTitle());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void shutDown(){
        driver.close();
        driver.quit();
    }
}
