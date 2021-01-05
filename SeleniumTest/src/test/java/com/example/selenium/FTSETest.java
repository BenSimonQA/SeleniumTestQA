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

public class FTSETest {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        driver.findElement(By.cssSelector("#acceptCookie")).click();
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void dressSearch() throws InterruptedException {
        
        WebElement risers = driver.findElement(By.cssSelector(".one-line:nth-child(2) strong"));
        risers.click();
        WebElement highest = driver.findElement(By.cssSelector("#ls-row-NXT-L > td:nth-child(1)"));
        String highText = highest.getText();
        assertEquals(highText, highest.getText());
        WebElement fallers = driver.findElement(By.cssSelector(".one-line:nth-child(3) > .link-headline"));
        fallers.click();
        WebElement lowest = driver.findElement(By.cssSelector("#ls-row-SKG-L > td:nth-child(1)"));
        String lowText = lowest.getText();
        assertEquals(lowText, lowest.getText());

        
    }
}
