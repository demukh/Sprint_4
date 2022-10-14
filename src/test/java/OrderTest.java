import PageObject.AboutRent;
import PageObject.FAQHomePage;
import PageObject.WhooseScooter;
import PageObject.mainpage;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.ui.WebDriverWait;



@RunWith(Parameterized.class)
public class OrderTest {

    WebDriver driver;
    String expected = "Заказ оформлен";

    private final String
            name,
            firstname,
            address,
            phone;
    private final int number;

    public OrderTest(int number, String name, String firstname, String address, String Phone) {
        this.number = number;
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.phone = Phone;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1, "Иван", "Иванов", "Москва", "+79991234567"},
                {2, "Петр", "Петров", "Люберцы", "+799859876543"},
        };

    }
    @Before
    public void startSamokat() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        FAQHomePage faqHomePage = new FAQHomePage(driver);
        faqHomePage.clickCloseCookies();
    }
    @Test
    public void checkOrderButton() {
        mainpage mainpage = new mainpage(driver);
        if (number == 1) {mainpage.clickOrderButtonOne();}
        if (number == 2) {mainpage.clickBigOrderButton();}

        WhooseScooter orderPage = new WhooseScooter(driver);
        orderPage.orderPageOne(name, firstname, address, phone);

        AboutRent orderPageRent = new AboutRent(driver);
        orderPageRent.secondOrderPage();

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]")).click(); //подтверждение заказа

        String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[1]")).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
        System.out.println(actual);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}