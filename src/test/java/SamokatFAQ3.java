import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SamokatFAQ3 {

    private WebDriver driver;
    String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    @Before
    public void start() {driver = new ChromeDriver();}

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.id("rcc-confirm-button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-2")));
        driver.findElement(By.id("accordion__heading-2")).click();
        String actual = driver.findElement(By.xpath(".//div[@id='accordion__panel-2']//p")).getText();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}