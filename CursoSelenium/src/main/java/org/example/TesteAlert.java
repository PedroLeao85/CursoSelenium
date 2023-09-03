package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

    @Test
    public void deveInteragirComAlertSimples() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\Documents\\Selenium\\VersaoSelenium\\116\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        WebElement botao = driver.findElement(By.id("alert"));
        botao.click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples" , texto);
        alert.accept();

        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

        driver.quit();

    }
    @Test
    public void deveInteragirComAlertConfirm() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\Documents\\Selenium\\VersaoSelenium\\116\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples" , alert.getText());
        alert.accept();
        Assert.assertEquals("Confirmado" , alert.getText());
        alert.accept();

        driver.quit();

    }
    @Test
    public void deveInteragirComAlertCancela() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\Documents\\Selenium\\VersaoSelenium\\116\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        WebElement cancela = driver.findElement(By.id("Confirm"));
        cancela.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples" , alert.getText());
        alert.dismiss();
        Assert.assertEquals("Negado" , alert.getText());
        alert.dismiss();


        driver.quit();
    }

    @Test
    public void deveInteragirComPrompt() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\Documents\\Selenium\\VersaoSelenium\\116\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero" , alert.getText());
        alert.sendKeys("13");
        alert.accept();
        Assert.assertEquals("Era 13?" , alert.getText());
        alert.accept();
        Assert.assertEquals(":D" , alert.getText());
        alert.accept();

        driver.quit();
    }
}
