package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        //Browserlari kullanabilmek icin WebDriverManager kutuphanesini kullaniyor
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");

        //aramaKutusuna gidelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //arama kutusuna "samsung headphones" yazalim
        aramaKutusu.sendKeys("samsung headphones" + Keys.ENTER);
        //sonuc sayisini bulalim
        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());
        //ilk urunu bulalim
        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());
        //sayfadaki butun urunleri bulalim, bu sayfadaki basliklar ayni koda sahip
        List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for (WebElement w: listem) {
            System.out.println(w.getText());
        }

        //istedigimiz siradaki urune ulasabiliriz mesela 5.siradaki (index 4)
        listem.get(4).getText();
    }
}
