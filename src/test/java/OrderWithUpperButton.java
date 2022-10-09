import PageObject.AboutRent;
import PageObject.WhooseScooter;
import PageObject.mainpage;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;


public class OrderWithUpperButton {

    private WebDriver driver;
    String expected = "Заказ оформлен";

    @Before
    public void start() {driver = new ChromeDriver();} //включить хром
    //public void start() {driver = new FirefoxDriver();}  //включить файрфокс


    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();

        mainpage objmainpage = new mainpage(driver);
        objmainpage.clickCookiesButton();
        objmainpage.clickOrderButtonOne();

        WhooseScooter objWhooseScooter = new WhooseScooter(driver);
        objWhooseScooter.orderPageOne("Иван", "Иванов", "Москва", "89991234567"); //введите данные

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.secondOrderPage();

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]")).click(); //подтверждение заказа

        String actual = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[5]/div[1]")).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
        System.out.println(actual);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}