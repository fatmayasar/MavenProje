package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://google.com");
        String googleTitle = driver.getTitle();
        System.out.println(googleTitle);
        // google.com sayfasinin title'inda Arama kelimesi varmi yok mu test edelim
        Assert.assertEquals("Arama", googleTitle);

    }
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        //amazon.com sayfasinin basiligi Amazon kelimesini iceriyor mu test edelim
        String titleAmazon = driver.getTitle();
        System.out.println(titleAmazon);

        boolean iceriyorMu = titleAmazon.contains("Amazon");
        Assert.assertTrue(iceriyorMu);
        //assertTrue dedik beklenti bunu dogrulamasi, eger iceriyorsa testi gecmesini istiyoruz
    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        //facebook.com'in title'i youtube icermesin istiyoruz ve bunu test edelim
        String titleFacebook = driver.getTitle();
        boolean iceriyorMu = titleFacebook.contains("Youtube");
        Assert.assertFalse(iceriyorMu); // false oldugunu dogrula

    }
    @Test
    public void test4(){
        driver.get("http://google.com");
        String googleTitle = driver.getTitle();
        System.out.println("Test calisti...");
        // google.com sayfasinin title'inda Arama kelimesi varmi yok mu test edelim
        Assert.assertEquals("Arama", googleTitle);
        System.out.println("Test basarili...");
    }
    @Test
    public void test5(){
        driver.get("http://amazon.com");
        //amazon.com sayfasinin basiligi Amazon kelimesini iceriyor mu test edelim
        String titleAmazon = driver.getTitle();
        boolean iceriyorMu = titleAmazon.contains("Amazon");
        Assert.assertTrue(iceriyorMu);
        System.out.println("Test basarili...");
    }


}
