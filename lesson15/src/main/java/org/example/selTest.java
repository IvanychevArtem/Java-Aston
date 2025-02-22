package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class selTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        try {

            driver.get("https://www.mts.by");

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            WebElement text = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));

            System.out.println("блок найден: " + text.getText());

            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement cookie = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
                cookie.click();
            } catch (TimeoutException e) {
                System.out.println("продолжаем");
            }


            List<WebElement> logo = driver.findElements(By.xpath("//div[@class='pay__partners']//img[contains(@alt, 'Visa') or contains(@alt, 'Verified By Visa') or contains(@alt, 'MasterCard') or contains(@alt, 'MasterCard Secure Code') or contains(@alt, 'Белкарт')]"));

            System.out.println("блок найден: " + logo.size());

            WebElement link = driver.findElement(By.xpath("//a[normalize-space() = 'Подробнее о сервисе']"));

            link.click();

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            driver.navigate().back();

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            System.out.println("Ссылка работает");
            try {
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement cookie2 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
                cookie2.click();
            } catch (TimeoutException e) {
                System.out.println("продолжаем");
            }

            WebElement number = driver.findElement(By.id("connection-phone"));
            number.click();
            number.sendKeys("297777777");
            System.out.println("номер введен");
            WebElement summ = driver.findElement(By.id("connection-sum"));
            number.click();
            summ.sendKeys("10");
            System.out.println("сумма введена");
            WebElement Continue = driver.findElement(By.xpath("//button[normalize-space() = 'Продолжить']"));
            Continue.click();
            System.out.println("кнопка нажата");


        } catch (Exception e) {
            System.out.println("Ошибка:" + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}