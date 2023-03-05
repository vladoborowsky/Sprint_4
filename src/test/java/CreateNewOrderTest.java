import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import utils.BaseTest;

import java.util.Objects;


@RunWith(Parameterized.class)
public class CreateNewOrderTest extends BaseTest {

    private final String orderButtonLocation;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final String date;
    private final String rentalTime;
    private final String color;
    private final String comment;

    public CreateNewOrderTest(String orderButtonLocation, String firstName, String lastName, String address, String subwayStation, String phone, String date, String rentalTime, String color, String comment) {
        this.orderButtonLocation = orderButtonLocation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.rentalTime = rentalTime;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestParam() {
        return new Object[][]{
                {
                        "Top",
                        "Влад",
                        "Оборовский",
                        "Шипиловский пр-д",
                        "Орехово",
                        "89080775054",
                        "31.03.2023",
                        "сутки",
                        "чёрный жемчуг",
                        "Первый тестовый заказ",
                },
                {
                        "Middle",
                        "Влада",
                        "Рейнхольд",
                        "ул. Хлобыстова, 9",
                        "Выхино",
                        "+79080775054",
                        "01.05.2023",
                        "трое суток",
                        "серая безысходность",
                        "Второй тестовый заказ",
                },
        };
    }

    @Test()
    public void compareQuestionAndAnswer() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        if (Objects.equals(orderButtonLocation, "Top")) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonMiddle();
        }
        OrderPage orderPage = new OrderPage(driver);
        orderPage.FillingOrderPartOne(firstName, lastName, address, subwayStation, phone);
        orderPage.orderNextButtonClick();
        orderPage.FillingOrderPartTwo(date, rentalTime, color, comment);
        orderPage.orderCompleteButtonClick();
        orderPage.orderConfirmButtonClick();
        boolean result = orderPage.orderCheckStatus();
        Assert.assertTrue(result);
    }
}