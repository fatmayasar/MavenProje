package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        
    }

    @AfterClass
    public  static void tearDown(){
        //driver.quit();
    }
}
