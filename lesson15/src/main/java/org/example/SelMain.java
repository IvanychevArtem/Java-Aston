package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SelMain extends BasePage {

    private final By headerBlock = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private final By cookieAgree = By.id("cookie-agree");
    private final By logos = By.xpath("//div[@class='pay__partners']//img[@alt = 'Visa' or @alt = 'Verified By Visa' or @alt = 'MasterCard' or @alt = 'MasterCard Secure Code' or @alt = 'Белкарт']");
    private final By serviceLink = By.xpath("//a[normalize-space() = 'Подробнее о сервисе']");
    private final By inLink = By.xpath("//h3[contains(text(), 'Оплата банковской картой')]");
    private final By phoneField = By.id("connection-phone");
    private final By sumField = By.id("connection-sum");
    private final By continueButton = By.xpath("//button[normalize-space() = 'Продолжить']");
    private final By Frame = By.xpath("//iframe[@class = 'bepaid-iframe']");

    public SelMain(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(headerBlock).getText().replaceAll("\n|\r\n", " ");
    }

    public void acceptCookies() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.presenceOfElementLocated(cookieAgree));
            cookie.click();
        } catch (Exception e) {
            System.out.println("Куки не появились");
        }
    }

    public List<WebElement> getLogos() {
        return driver.findElements(logos);
    }

    public void checkLogos() {
        for (WebElement logo : getLogos()) {
            String altText = logo.getAttribute("alt");

            if (altText.equals("Visa")) {
                System.out.println("Найден логотип Visa");
            } else if (altText.equals("Verified By Visa")) {
                System.out.println("Найден логотип Verified By Visa");
            } else if (altText.equals("MasterCard")) {
                System.out.println("Найден логотип MasterCard");
            } else if (altText.equals("MasterCard Secure Code")) {
                System.out.println("Найден логотип MasterCard Secure Code");
            } else if (altText.equals("Белкарт")) {
                System.out.println("Найден логотип Белкарт");
            } else {
                throw new RuntimeException("Неизвестный логотип: " + altText);
            }
        }
    }

    public void clickServiceLink() {
        driver.findElement(serviceLink).click();
    }

    public String getInLinkText() {
        return driver.findElement(inLink).getText();
    }

    public void enterPhoneNumber(String number) {
        WebElement phoneInput = driver.findElement(phoneField);
        phoneInput.click();
        phoneInput.sendKeys(number);
    }

    public void enterSum(String sum) {
        WebElement sumInput = driver.findElement(sumField);
        sumInput.click();
        sumInput.sendKeys(sum);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void iframe() {
        WebElement iframe = driver.findElement(Frame);
        driver.switchTo().frame(iframe);
    }

}
