package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.ListCell;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        //select class'indan nesne uretmeden dropdown uzerinde islem yapilamaz
        //select class;indan nesne uretme diyebiliriz dropdown icin
        Select select = new Select(dropDown);
        //2 sn bekleyelim
        try{
         Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //secenegin yazisina gore secim yapabiliriz
        //Baby secenegini bulalim
        select.selectByVisibleText("Baby");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Automotive secenegini bulalim
        select.selectByVisibleText("Automotive");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //secenegin bulundugu siraya gore secim yapabiliriz
        //6. siradaki elementi bulalim
        select.selectByIndex(5);
        //sectigimiz secenegi yazdiralim
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());
        //DropDown'daki tum secenekleri yazdiralim
        List<WebElement> liste = select.getOptions();
        for (WebElement webElement : liste) {
            System.out.println(webElement.getText());
        }
        //bu listede bulunan seceneklerin sayisini bulalim
        int tolamSecenekSayisi = liste.size();
        System.out.println("Toplam secenek sayisi = "+tolamSecenekSayisi);



    }

}
