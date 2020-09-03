package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {
    static WebDriver driver;// instance variable
    @BeforeClass
    public static void  setUp(){
        //driver'i kullanabilir hale getiriryoruz
        WebDriverManager.chromedriver().setup();
        //driver nesnesini olusturalim
        driver = new ChromeDriver();
        //driver komutlarini yazalim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public  void test1(){
        //google.com'a gidelim
        driver.get("http://google.com");
        //google resminin gorunup gorunmedigini inceleyelim
        WebElement logo = driver.findElement(By.id("hplogo"));
        //eger webelement kullaniciya gosteriliyorsa, TRUE
        //eger webelement kullaniciya gosterilmkiyorsa, FALSE
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
        System.out.println("Test basarili..");
    }
    @AfterClass
    public  static void tearDown(){
        //driver.quit();
    }
}
