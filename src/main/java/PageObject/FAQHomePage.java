package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Класс страницы вопросы
public class FAQHomePage {

    private final By
    HOME_FAQ = By.cssSelector("div.Home_FAQ__3uVm4"),

    COOKIES = By.id("rcc-confirm-button");

    private WebDriver driver;


    public void clickCloseCookies() {
        driver.findElement(COOKIES).click();
    }

    public boolean isAnswerVisible(String constantText, int index) {
        By panelAnswer = By.id("accordion__panel-" + index);
        return driver.findElement(panelAnswer).isDisplayed();
    }

    // нажать на на стрелку с вопросом
    public void clickOnQuestion(int index) {
        By buttonText = By.id("accordion__heading-" + index);
        driver.findElement(buttonText).click();
    }

    public FAQHomePage(WebDriver driver) {

        this.driver = driver;
    }
    public void scrollQuestions() {
        new WebDriverWait(driver, (5)).until(ExpectedConditions.visibilityOfElementLocated(HOME_FAQ));

        WebElement elementFAQ = driver.findElement(HOME_FAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementFAQ);
    }
}