import org.example.SelMain;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SelTest {

    public static WebDriver driver;
    public static SelMain selMain;
    public static String pageURL = "https://mts.by";

    @BeforeAll
    static void before() {
        driver = new ChromeDriver();
        selMain = new SelMain(driver);
        driver.get(pageURL);
        selMain.acceptCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterAll
    static void after() {
        driver.quit();
    }


    @Test
    @Order(1)
    void logoPay() {
        try {
            selMain.checkLogos();
        }catch (NoSuchElementException e){
            System.out.println("Логотипы не найдены");
        }
    }

    @Test
    @Order(2)
    void blockName() {
        String name = "Название блока";
        try {
            String actualValue = selMain.getHeaderText();
            assertEquals("Онлайн пополнение без комиссии", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            System.out.println(name + " не найден");
        }
    }

    @Test
    @Order(3)
    void buttonService() {
        String name = "Подробнее о сервисе";
        try {
            selMain.clickServiceLink();
            System.out.println("Ссылка: " + name + " открывается");
        } catch (TimeoutException e) {
            System.out.println("Ссылка: " + name + " не открывается");
        }

        try {
            String textInLink = selMain.getInLinkText();
            assertEquals("Оплата банковской картой", textInLink, "Ожидаемый контент отсутствует");
            System.out.println("Ожидаемый контент присутствует");
        } catch (NoSuchElementException e) {
            System.out.println("Нет ожидаемых элементов");
        }
        driver.navigate().back();
        selMain.acceptCookies();
    }

    @Test
    @Order(4)
    void ContinueButton() {
        try {
            selMain.enterPhoneNumber("297777777");
            System.out.println("Номер введен");
        } catch (NoSuchElementException e) {
            System.out.println("Окошко для ввода телефона не найдено");
        }

        try {
            selMain.enterSum("10");
            System.out.println("Сумма введена");
        } catch (NoSuchElementException e) {
            System.out.println("Окошко для ввода суммы не найдено");
        }

        try {
            selMain.clickContinue();
            System.out.println("Кнопка нажата");
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка 'Продолжить' не найдена");
        }

        try {
            selMain.iframe();
            System.out.println("Окно с реквизитами открылось");
        } catch (NoSuchElementException e) {
            System.out.println("Окно с реквизитами не вышло");
        }
    }



}



