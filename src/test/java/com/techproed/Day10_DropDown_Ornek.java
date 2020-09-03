package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day10_DropDown_Ornek {
    //Amazon.com'a gidelim
    //DropDown uzerinden SoftWare secelim
    //Arama kutusuna JAVA yazdiralim ve arama yapalim
    //sonuc sayisini ekrana yazdiralim
    //sonuc sayisinda JAVA gextigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Software");
        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("JAVA"+ Keys.ENTER);
        WebElement sonucSayisi =driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());

        Assert.assertTrue(sonucSayisi.getText().contains("for"));

    }
}
