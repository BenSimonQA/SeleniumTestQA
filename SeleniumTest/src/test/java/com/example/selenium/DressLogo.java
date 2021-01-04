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

public class DressLogo {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://automationpractice.com/index.php");
    }
    
    @After
    public void tearDown() {
        driver.close();
    }
    
    @Test
    public void dressSearch() throws InterruptedException {
        
        WebElement search = driver.findElement(By.id("search_query_top"));
        String item = "faded";
    	search.sendKeys(item);
        WebElement submit = driver.findElement(By.name("submit_search"));
        submit.click();
        WebElement resultItem = driver.findElement(By.cssSelector(".product_img_link > .replace-2x"));
        resultItem.click();
        WebElement itemName = driver.findElement(By.cssSelector("h1"));
        assertEquals("Faded Short Sleeve T-shirts", itemName.getText());
        
    }
}
