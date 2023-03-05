package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By orderButtonTopLocator = By.xpath("//div[contains(@class, 'Header')]//button[contains(text(),'Заказать')]");
    private final By orderButtonMiddleLocator = By.xpath("//div[contains(@class, 'Home_Finish')]//button[contains(text(),'Заказать')]");

    public void clickOrderButtonTop() {
        WebElement element = driver.findElement(orderButtonTopLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    public void clickOrderButtonMiddle() {
        WebElement element = driver.findElement(orderButtonMiddleLocator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    public void clickQuestionView(String text) {
        By locator = By.xpath("//div[contains(@class, 'Home_FAQ')]//div[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        element.click();
    }

    public boolean checkAnswerQuestionView(String text) {
        By locator = By.xpath("//div[contains(@class, 'Home_FAQ')]//p[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

        return element.isDisplayed();
    }
}
