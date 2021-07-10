package com.advantageshopping.automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


import java.util.concurrent.TimeUnit;

public class RegisterNewUserStepDefinitions {

    public WebDriver driver;

    @Given("^that a web user wants to register in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/register");
        driver.manage().timeouts().pageLoadTimeout(6,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

    }

    String username = "kamishans";
    String email = "kamishan@hotmail.es";
    String password = "Testingpass1";

    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() {


        driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
        driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
        driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Kamishan");
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Sempou");
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("3016829886");
        driver.findElement(By.xpath("//option[@label='Colombia']")).click();
        driver.findElement(By.name("cityRegisterPage")).sendKeys("Cartagena");
        driver.findElement(By.name("addressRegisterPage")).sendKeys("Cra 100# 39E - 33");
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Bolivar");
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("110010");
        driver.findElement(By.name("allowOffersPromotion")).click();
        driver.findElement(By.name("i_agree")).click();
        driver.findElement(By.id("register_btnundefined")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() throws InterruptedException {
        driver.quit();
    }

}
