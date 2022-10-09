import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SamokatFAQ7 {

    private WebDriver driver;
    String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    @Before
    public void start() {driver = new ChromeDriver();}

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.id("rcc-confirm-button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-6")));
        driver.findElement(By.id("accordion__heading-6")).click();
        String actual = driver.findElement(By.xpath(".//div[@id='accordion__panel-6']//p")).getText();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}