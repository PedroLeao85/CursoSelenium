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


}
