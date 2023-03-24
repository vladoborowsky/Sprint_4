package pages;

import org.openqa.selenium.*;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //////////////////////////////////////////////////////////

    private final By fieldFirstNameLocator = By.xpath("//input[contains(@placeholder, 'Имя')]");
    private final By fieldLastNameLocator = By.xpath("//input[contains(@placeholder, 'Фамилия')]");
    private final By fieldAddressLocator = By.xpath("//input[contains(@placeholder, 'Адрес')]");
    private final By fieldSubwayStationLocator = By.xpath("//input[contains(@placeholder, 'Станция метро')]");
    private final By fieldPhoneLocator = By.xpath("//input[contains(@placeholder, 'Телефон')]");
    private final By orderNextButton = By.xpath("//div[contains(@class, 'Order_NextButton')]//button");

    //////////////////////////////////////////////////////////

    private final By fieldDateLocator = By.xpath("//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By fieldRentalTimeLocator = By.xpath("//div[contains(@class, 'Dropdown-root')]");
    private final By fieldCommentLocator = By.xpath("//input[contains(@placeholder, 'Комментарий для курьера')]");
    private final By orderCompleteButtonLocator = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[contains(text(), 'Заказать')]");

    //////////////////////////////////////////////////////////

    private final By orderConfirmButtonLocator = By.xpath("//button[contains(text(), 'Да')]");
    private final By checkStatusButtonLocator = By.xpath("//div[contains(text(), 'Заказ оформлен')]");


    public void FillingOrderPartOne(String firstName, String lastName, String address, String subwayStation, String phone) {
        WebElement element;
        element = driver.findElement(fieldFirstNameLocator);
        element.sendKeys(firstName);

        element = driver.findElement(fieldLastNameLocator);
        element.sendKeys(lastName);

        element = driver.findElement(fieldAddressLocator);
        element.sendKeys(address);

        element = driver.findElement(fieldSubwayStationLocator);
        element.sendKeys(subwayStation);
        element.sendKeys(Keys.DOWN, Keys.RETURN);


        element = driver.findElement(fieldPhoneLocator);
        element.sendKeys(phone);
    }

    public void orderNextButtonClick() {
        WebElement element = driver.findElement(orderNextButton);
        element.click();
    }

    public void FillingOrderPartTwo(String date, String rentalTime, String color, String comment) {
        WebElement element;
        element = driver.findElement(fieldDateLocator);
        element.sendKeys(date, Keys.RETURN);

        element = driver.findElement(fieldRentalTimeLocator);
        element.click();
        By locator = By.xpath("//div[@class='Dropdown-option' and text() = '" + rentalTime + "']");
        element = driver.findElement(locator);
        element.click();

        locator = By.xpath("//label[text()='" + color + "']");
        element = driver.findElement(locator);
        element.click();

        element = driver.findElement(fieldCommentLocator);
        element.sendKeys(comment);
    }

    public void orderCompleteButtonClick() {
        WebElement element = driver.findElement(orderCompleteButtonLocator);
        element.click();
    }

    public void orderConfirmButtonClick() {
        WebElement element = driver.findElement(orderConfirmButtonLocator);
        element.click();
    }

    public boolean orderCheckStatus() {
        WebElement element = driver.findElement(checkStatusButtonLocator);
        return element.isDisplayed();
    }
}
