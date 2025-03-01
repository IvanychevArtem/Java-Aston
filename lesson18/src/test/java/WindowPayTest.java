

import org.example.MainPage;
import org.example.PayPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Тестирование оплаты на сайте MTS")
@Feature("Проверка платежной формы")
public class WindowPayTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static PayPage payPage;
    public static final String pageURL = "https://mts.by";
    public static final String testPhoneNumber = "297777777";
    public static final String testSum = "10.50";

    @BeforeAll
    @Step("Инициализация WebDriver и открытие главной страницы")
    static void before() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(pageURL);
        mainPage.acceptCookies();
        mainPage.setConnectionSum(testSum);
        mainPage.setConnectionPhone(testPhoneNumber);
        mainPage.clickPay();
        payPage = new PayPage(driver, mainPage.payFrame);
    }

    @AfterAll
    @Step("Закрытие WebDriver")
    static void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Проверка описания суммы")
    @Description("Проверяет, что сумма в заголовке платежной формы совпадает с заданной")
    void descriptionCost() {
        String name = "Текст описания суммы в заголовке";
        try {
            String actualValue = payPage.getPayFrameDescriptionCost();
            assertEquals(testSum + " BYN", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            System.out.println(name + " не найден");
            fail(name + " не найден: " + e.getMessage());
        }
    }

    @Test
    @Story("Проверка текста кнопки")
    @Description("Проверяет, что текст кнопки оплаты соответствует заданной сумме")
    void btnText() {
        String name = "Текст кнопки";
        try {
            String actualValue = payPage.getPayFrameBtnText();
            assertEquals("Оплатить " + testSum + " BYN", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            System.out.println(name + " не найден");
            fail(name + " не найден: " + e.getMessage());
        }
    }

    @Test
    @Story("Проверка номера телефона")
    @Description("Проверяет, что номер телефона в заголовке платежной формы совпадает с заданным")
    void descriptionPhone() {
        String name = "Номер телефона в заголовке";
        try {
            String actualValue = payPage.getPayFrameDescriptionPhone();
            assertEquals("Оплата: Услуги связи Номер:375" + testPhoneNumber, actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            System.out.println(name + " не найден");
            fail(name + " не найден: " + e.getMessage());
        }
    }

    @Test
    @Story("Проверка отображения изображений платежных систем")
    @Description("Проверяет отображение всех изображений платежных систем")
    void checkPaymentImages() {
        String[] images = {
                "mastercard-system.svg",
                "visa-system.svg",
                "belkart-system.svg",
                "mir-system-ru.svg",
                "maestro-system.svg"
        };

        for (String src : images) {
            boolean isDisplayed = payPage.isDisplayedImg(src);
            assertTrue(isDisplayed, "Картинка " + src + " не отображается");
            System.out.println("Картинка " + src + " отображается");
        }
    }

    @Test
    @Story("Проверка placeholder'ов полей формы")
    @Description("Проверяет корректность placeholder'ов всех полей формы оплаты")
    void checkPlaceholders() {
        try {
            String cardNumberPlaceholder = payPage.getCreditCardPlaceholder();
            assertEquals("Номер карты", cardNumberPlaceholder, "Поле ввода номера карты не совпадает");
            System.out.println("Поле ввода номера карты совпадает");
        } catch (NoSuchElementException e) {
            System.out.println("Поле ввода номера карты не найдено");
            fail("Поле ввода номера карты не найдено: " + e.getMessage());
        }
        try {
            String expirationDatePlaceholder = payPage.getExpirationDatePlaceholder();
            assertEquals("Срок действия", expirationDatePlaceholder, "Поле ввода срока действия карты не совпадает");
            System.out.println("Поле ввода срока действия карты совпадает");
        } catch (NoSuchElementException e) {
            System.out.println("Поле ввода срока действия карты не найдено");
            fail("Поле ввода срока действия карты не найдено: " + e.getMessage());
        }
        try {
            String cvcPlaceholder = payPage.getCvcPlaceholder();
            assertEquals("CVC", cvcPlaceholder, "Поле ввода CVC не совпадает");
            System.out.println("Поле ввода CVC совпадает");
        } catch (NoSuchElementException e) {
            System.out.println("Поле ввода CVC не найдено");
            fail("Поле ввода CVC не найдено: " + e.getMessage());
        }
        try {
            String cardHolderPlaceholder = payPage.getCardHolderPlaceholder();
            assertEquals("Имя держателя (как на карте)", cardHolderPlaceholder, "Поле ввода имени держателя не совпадает");
            System.out.println("Поле ввода имени держателя совпадает");
        } catch (NoSuchElementException e) {
            System.out.println("Поле ввода имени держателя не найдено");
            fail("Поле ввода имени держателя не найдено: " + e.getMessage());
        }
    }
}