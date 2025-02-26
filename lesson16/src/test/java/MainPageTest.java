import org.example.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static String pageURL = "https://mts.by";

    @BeforeAll
    static void before() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(pageURL);
        mainPage.acceptCookies();
    }

    @AfterAll
    static void after() {
        driver.quit();
    }

    @Test
    void blockName(){
        String name = "Название блока";
        try {
            String actualValue = mainPage.getHeaderText();
            assertEquals("Онлайн пополнение без комиссии", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            System.out.println(name + " не найден");
        }
    }

@Test
void buttonService(){
        String name = "Подробнее о сервисе";
        try {
            mainPage.clickServiceLink();
            System.out.println("Ссылка: " + name + " открывается");
        }catch(TimeoutException e){
            System.out.println("Ссылка: " + name + " не открывается");
        }

        try{
String textInLink = mainPage.getInLinkText();
assertEquals("Оплата банковской картой", textInLink, "Ожидаемый контент отсутствует");
            System.out.println("Ожидаемая контент присутствует");
        }catch (NoSuchElementException e){
            System.out.println("Нет ожидаемых элементов");
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
    public void checkPlaceholders(String fieldId, String expectedPlaceholder) {
        String actualPlaceholder = getPlaceholder(fieldId);
        assertEquals(expectedPlaceholder, actualPlaceholder, fieldId + " плейсхолдер не соответствует");
    }

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

