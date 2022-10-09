import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SamokatFAQ1 {
    private WebDriver driver;
    String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    @Before
    public void start() {driver = new ChromeDriver();}
    //public void start() {driver = new FirefoxDriver();} //включить файрфокс

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.id("rcc-confirm-button")).click();
        //WebElement element = driver.findElement(By.id("accordion__heading-0"));     оставлено на случай, если тест зафейлится, почему-то иногда они падают
       // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);  если подскажете почему тесты иногда падают, буду благодарна!
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("accordion__heading-0")).click();

        String actual = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']//p")).getText();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}