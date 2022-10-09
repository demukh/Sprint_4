package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class mainpage {
    private WebDriver driver;
    private By cookiesButton = By.id("rcc-confirm-button"); // кнопка куков
    private By orderButtonOne = By.className("Button_Button__ra12g"); // кнопка заказа сверху
    private By bigOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button"); // большая кнопка заказа снизу

    public mainpage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCookiesButton() {
        driver.findElement(cookiesButton).click();
    }
    public void clickOrderButtonOne() {
        driver.findElement(orderButtonOne).click();
    }
    public void clickBigOrderButton() {
        driver.findElement(bigOrderButton).click();
    }



}
