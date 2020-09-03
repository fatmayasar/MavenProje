package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed_Ornek {
    /*
    1)www.bestbuy.com adresine gidin
    2)titleTest==> sayfabasliginin "Best" icerdigini dogrulayin
    3)logoTest ==> BestBuy logosunun gorunurlugunu dogrulayin
    4)mexicoLinkTest ==> Linkin gorunurlugunu dogrulayin
    *her testten sonra tarayiciyi kapatin
    *@Before ve @After methodlarini kullanarak yapiniz
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.bestbuy.com");
    }
    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void titleTest(){

        String title = driver.getTitle();
        boolean iceriyorMU = title.contains("Best");
        Assert.assertTrue(iceriyorMU);

    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
    }
    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLink = driver.findElement(By.partialLinkText("Mexico"));
        boolean gorunuyorMu = mexicoLink.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
    }

}
