package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestCadastro {

    @Test
    public void Cadastro(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\Documents\\Selenium\\VersaoSelenium\\116\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Carlos");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lopes");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Carlos"));
        Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Lopes"));
        Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Frango"));
        Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
        Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Futebol"));

        driver.quit();
    }
}
