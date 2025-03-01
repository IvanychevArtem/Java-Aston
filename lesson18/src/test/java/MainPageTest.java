

import io.qameta.allure.*;
import io.qameta.allure.model.Status;
import org.example.MainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование главной страницы MTS")
@Feature("Основные элементы страницы")
public class MainPageTest {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static String pageURL = "https://mts.by";

    @BeforeAll
    @Step("Запуск браузера и открытие главной страницы")
    static void before() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(pageURL);
        mainPage.acceptCookies();
    }

    @AfterAll
    @Step("Закрытие браузера")
    static void after() {
        driver.quit();
    }

    @Test
    @Story("Проверка заголовка блока")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяет заголовок основного блока на главной странице")
    void blockName() {
        String name = "Название блока";
        try {
            String actualValue = mainPage.getHeaderText();
            assertEquals("Онлайн пополнение без комиссии", actualValue, name + " не совпадает");
            Allure.step(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            Allure.step(name + " не найден", Status.FAILED);
        }
    }

    @Test
    @Story("Проверка кнопки сервиса")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяет работу кнопки 'Подробнее о сервисе'")
    void buttonService() {
        String name = "Подробнее о сервисе";
        try {
            mainPage.clickServiceLink();
            Allure.step("Ссылка: " + name + " открывается");
        } catch (TimeoutException e) {
            Allure.step("Ссылка: " + name + " не открывается", Status.FAILED);
        }

        try {
            String textInLink = mainPage.getInLinkText();
            assertEquals("Оплата банковской картой", textInLink, "Ожидаемый контент отсутствует");
            Allure.step("Ожидаемый контент присутствует");
        } catch (NoSuchElementException e) {
            Allure.step("Нет ожидаемых элементов", Status.FAILED);
        }
        driver.navigate().back();
    }

    @ParameterizedTest
    @CsvSource({
            "connection-phone, Номер телефона",
            "connection-sum, Сумма",
            "connection-email, E-mail для отправки чека",
            "internet-phone, Номер абонента",
            "internet-sum, Сумма",
            "internet-email, E-mail для отправки чека",
            "score-instalment, Номер счета на 44",
            "instalment-sum, Сумма",
            "instalment-email, E-mail для отправки чека",
            "score-arrears, Номер счета на 2073",
            "arrears-sum, Сумма",
            "arrears-email, E-mail для отправки чека"
    })
    @Story("Проверка плейсхолдеров полей")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверяет правильность отображения плейсхолдеров в полях")
    public void checkPlaceholders(String fieldId, String expectedPlaceholder) {
        String actualPlaceholder = getPlaceholder(fieldId);
        assertEquals(expectedPlaceholder, actualPlaceholder, fieldId + " плейсхолдер не соответствует");
        Allure.step("Плейсхолдер для " + fieldId + " соответствует ожидаемому: " + expectedPlaceholder);
    }

    @Step("Получение плейсхолдера для {fieldId}")
    private String getPlaceholder(String fieldId) {
        switch (fieldId) {
            case "connection-phone":
                return mainPage.getConnectionPhonePlaceholder();
            case "connection-sum":
                return mainPage.getConnectionSumPlaceholder();
            case "connection-email":
                return mainPage.getConnectionEmailPlaceholder();
            case "internet-phone":
                return mainPage.getInternetPhonePlaceholder();
            case "internet-sum":
                return mainPage.getInternetSumPlaceholder();
            case "internet-email":
                return mainPage.getInternetEmailPlaceholder();
            case "score-instalment":
                return mainPage.getInstalmentScorePlaceholder();
            case "instalment-sum":
                return mainPage.getInstalmentSumPlaceholder();
            case "instalment-email":
                return mainPage.getInstalmentEmailPlaceholder();
            case "score-arrears":
                return mainPage.getArrearsScorePlaceholder();
            case "arrears-sum":
                return mainPage.getArrearsSumPlaceholder();
            case "arrears-email":
                return mainPage.getArrearsEmailPlaceholder();
            default:
                throw new IllegalArgumentException("Invalid field ID: " + fieldId);
        }
    }
}
