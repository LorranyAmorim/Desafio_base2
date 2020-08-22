package DesafioBase2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Desafio {

    @Test
    public void mantisTeste() {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://mantis-prova.base2.com.br/ ");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));


        usernameField.sendKeys("lorrany.batista"); //login invalido
        passwordField.sendKeys("a1234567"); //senha correta
        loginButton.click();

        /*validar a mensagem de erro*/

        usernameField.clear();
        /*driver.navigate().to("https://mantis-prova.base2.com.br/ ");*/
        usernameField.sendKeys("lorrany.amorim"); //login valido
        passwordField.sendKeys("4"); //senha incorreta
        loginButton.click();

        /*validar a mensagem de erro*/

        usernameField.clear();
        usernameField.sendKeys("lorrany.amorim"); //login valido
        passwordField.sendKeys("a1234567"); //senha valida
        loginButton.click();

        /*validar se estou logado com o usuário inserido na tela de login*/

        WebElement ReportarIssue = driver.findElement(By.cssSelector("a[href^='/bug_report_page.php']"));
        ReportarIssue.click();

        Select combo = new Select(driver.findElement(By.name("category_id")));
        combo.selectByValue("42");

        Select combo2 = new Select(driver.findElement(By.name("priority")));
        combo2.selectByValue("40");

        WebElement descricaoField = driver.findElement(By.name("description"));
        WebElement checkButton = driver.findElement(By.name("report_stay"));
        WebElement submitButton = driver.findElement(By.xpath(("//input[@class='button']")));

        descricaoField.sendKeys("descrição_teste_desafio");
        checkButton.click();
        submitButton.click();

        /*validar mensagem de erro devido a falta de campo obrigatorio*/

        driver.navigate().to("https://mantis-prova.base2.com.br/ ");
        usernameField.sendKeys("lorrany.amorim"); //login valido
        passwordField.sendKeys("a1234567"); //senha valida
        loginButton.click();


        WebElement ReportarIssue2 = driver.findElement(By.cssSelector("a[href^='/bug_report_page.php']"));
        ReportarIssue2.click();

        Select combo3 = new Select(driver.findElement(By.name("category_id")));
        combo3.selectByValue("42");

        Select combo4 = new Select(driver.findElement(By.name("priority")));
        combo4.selectByValue("40");

        WebElement summaryField = driver.findElement(By.name("summary"));

        summaryField.sendKeys("Teste_21/08/2020_22:03");
        descricaoField.sendKeys("descrição_teste_desafio");
        Select radio = new Select(driver.findElement(By.name("view_state")));
        radio.selectByValue("50");
        checkButton.click();
        submitButton.click();

        /*validar mensagem de salvo com sucesso e comparar os valores inseridos nos campos para ver se são iguais
*/

    }
}