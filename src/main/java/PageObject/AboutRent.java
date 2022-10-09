package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AboutRent {
    private WebDriver driver;
    private By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // календарь
    private By forHowLongMenu = By.className("Dropdown-control");   // срок аренды
    private By howManyDays = By.xpath(".//div[@class='Dropdown-option'][3]"); // количество суток аренды
    private By colour = By.xpath(".//input[@id='black']");   //цвет черный
    private By orderButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]"); // кнопка Заказать
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    String date = LocalDate.now().plusDays(2).format(formatter); //дата

    public AboutRent(WebDriver driver){
        this.driver = driver;
 }

    public void setDate() {
        driver.findElement(calendar).click();
        driver.findElement(calendar).sendKeys(date);
        driver.findElement(calendar).sendKeys(Keys.ENTER);
    }

    public void setHowLong() {
        driver.findElement(forHowLongMenu).click();
        driver.findElement(howManyDays).click();
    }
    public void setColour() {
        driver.findElement(colour).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void secondOrderPage(){
        setDate();
        setHowLong();
        setColour();
        clickOrderButton();
    }
}


