package com.example.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightSignUpTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://demo.guru99.com/test/newtours/");
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void dressSearch() throws InterruptedException {
        
        WebElement register = driver.findElement(By.linkText("REGISTER"));
        register.click();
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("qwer");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("qwerlas");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("07452564586");
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("qwer@qwertt.erere");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("43 LandLand");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("LandLand");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("States");
        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("wr4 5gg");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("qwert");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwert");
        WebElement cpass = driver.findElement(By.name("confirmPassword"));
        cpass.sendKeys("qwert");
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();
        WebElement check = driver.findElement(By.cssSelector("p:nth-child(2) > font"));
        String registerText = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
        assertEquals(registerText, check.getText());
        WebElement signUp = driver.findElement(By.linkText("sign-in"));
        signUp.click();
        WebElement userr = driver.findElement(By.name("userName"));
        userr.sendKeys("qwert");
        WebElement passwordSign = driver.findElement(By.name("password"));
        passwordSign.sendKeys("qwert");
        WebElement submitSign = driver.findElement(By.cssSelector("td td:nth-child(2) tr:nth-child(1) > td"));
        submitSign.click();
        WebElement checkSign = driver.findElement(By.cssSelector("font > b"));
        String textSign = "Welcome back to Mercury Tours!";
        assertEquals(textSign, checkSign.getText());        
    }
    
}
