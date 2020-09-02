package etut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Annotations {
    /*
    ===Annotations Calismasi===
    1)test islemlerinden once webdriver nesnesini olusturalim
    2)driver nesnesini butun test method'larinda kullanabilecek sekilde tanimlayalim
    3)test islemleri bitince sayfalarimizi kapatalim
    4)youtube.com adresine gidelim
    5)arama butonunu bulalim
    6)arama butonuna 'Guldur Guldur 100. Bolum' ve 'Guldur Guldur 200. Bolum' yazdiralim
    7)her videonun 'goruntulenme sayisini' bulalim
    8)her videonun 'yayinlandigi tarihi bulalim'
    9)her videonun 'kim tarafindan yayinlandigini' bulalim
    10)son olarak 'guldur guldur 200. bolum' den vazgecelim ve
    sadece 'guldur guldur 100. bolum' icin testimizi yapalim.
     */
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
       driver.quit();
    }
    @Before
    public void beforeTest(){
       driver.get("http://youtube.com");
    }
    @After
    public void afterTest(){
        WebElement goruntulemeSayisi = driver.findElement(By.xpath("//span[@class='style-scope ytd-video-meta-block']"));
        System.out.println("goruntuleme sayisi ===>" +goruntulemeSayisi.getText());

        WebElement yayinlayanKisi = driver.findElement(By.xpath("//a[@class='yt-simple-endpoint style-scope yt-formatted-string']"));
        System.out.println("yayinlayan kisi ==>" + yayinlayanKisi.getText());
   }
    @Test
    public void test100(){
       //xpath   ===>   //tagName[@attribute='value']
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.sendKeys("guldur guldur 100. bolum"+ Keys.ENTER);
    }
    @Test
    public void test200(){
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.sendKeys("guldur guldur 200. bolum"+ Keys.ENTER);
    }

}
