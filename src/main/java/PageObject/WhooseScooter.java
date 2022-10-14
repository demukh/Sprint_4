package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WhooseScooter {
    private WebDriver driver;
    private By nameField = By.xpath(".//input[@placeholder='* Имя']"); // Имя
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");   //Фамилия
    private By adressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // Адрес
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");   //Метро
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // Адрес
    private By buttonNext = By.xpath("//*[@id='root']/div/div[2]/div[3]/button"); // Кнопка далее

    public WhooseScooter(WebDriver driver){
        this.driver = driver;
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void setAddress(String address) {
        driver.findElement(adressField).sendKeys(address);
    }
    public void setMetro() {
        driver.findElement(metroField).sendKeys("Белорусская");
        driver.findElement(By.xpath(".//button[@value='29']")).click();
    }
    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void orderPageOne(String name, String firstname, String address, String phone){ //заполнение первой страницы
        setName(name);
        setSurname(firstname);
        setAddress(address);
        setMetro();
        setPhone(phone);
        clickButtonNext();
    }

}
