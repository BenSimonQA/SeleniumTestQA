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

public class DemoSiteTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://thedemosite.co.uk/");
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void addUserTest() throws InterruptedException {
        
        WebElement addUser = driver.findElement(By.linkText("3. Add a User"));
    	addUser.click();
        WebElement username = driver.findElement(By.name("username"));
        String userGuest = "guest";
    	username.sendKeys(userGuest);
        WebElement password = driver.findElement(By.name("password"));
        String passGuest = "guest";
        password.sendKeys(passGuest);
        WebElement submit = driver.findElement(By.name("FormsButton2"));
        submit.click();
        WebElement logIn = driver.findElement(By.linkText("4. Login"));
        logIn.click();
        WebElement usernameLog = driver.findElement(By.name("username"));
    	usernameLog.sendKeys(userGuest);
        WebElement passwordLog = driver.findElement(By.name("password"));
        passwordLog.sendKeys(passGuest);
        WebElement submitLog = driver.findElement(By.name("FormsButton2"));
        submitLog.click();
        WebElement cssText = driver.findElement(By.cssSelector("center > b"));
        assertEquals("**Successful Login**", cssText.getText());
    }
}

