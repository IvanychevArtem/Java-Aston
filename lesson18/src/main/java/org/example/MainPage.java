package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    private final By headerBlock = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");

    private final By cookieAgree = By.id("cookie-agree");

    private final By serviceLink = By.xpath("//a[normalize-space() = 'Подробнее о сервисе']");

    private final By inLink = By.xpath("//h3[contains(text(), 'Оплата банковской картой')]");

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='connection-phone']")
    private WebElement connectionPhone;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='connection-sum']")
    private WebElement connectionSum;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='connection-email']")
    private WebElement connectionEmail;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='internet-phone']")
    private WebElement internetPhone;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='internet-sum']")
    private WebElement internetSum;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='internet-email']")
    private WebElement internetEmail;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='score-instalment']")
    private WebElement instalmentScore;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='instalment-sum']")
    private WebElement instalmentSum;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='instalment-email']")
    private WebElement instalmentEmail;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='score-arrears']")
    private WebElement arrearsScore;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='arrears-sum']")
    private WebElement arrearsSum;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//input[@id='arrears-email']")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//section[contains(@class, 'pay')]//button[@type='submit']")
    private WebElement pay;

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]")
    public WebElement payFrame;

    public void acceptCookies() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.presenceOfElementLocated( cookieAgree));
            cookie.click();
        } catch (Exception e) {
            System.out.println("Куки не появились");
        }
    }

    public String getHeaderText() {
        return driver.findElement(headerBlock).getText().replaceAll("\n|\r\n", " ");
    }

    public void clickServiceLink() {
        driver.findElement(serviceLink).click();
    }

    public String getInLinkText(){
        return driver.findElement(inLink).getText();
    }

    public String getConnectionPhonePlaceholder() {
        return connectionPhone.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return connectionSum.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return connectionEmail.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        return internetPhone.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return internetSum.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return internetEmail.getAttribute("placeholder");
    }

    public String getInstalmentScorePlaceholder() {
        return instalmentScore.getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return instalmentSum.getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return instalmentEmail.getAttribute("placeholder");
    }

    public String getArrearsScorePlaceholder() {
        return arrearsScore.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return arrearsSum.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return arrearsEmail.getAttribute("placeholder");
    }

    public void setConnectionPhone(String phoneNumber) {
        connectionPhone.sendKeys(phoneNumber);
    }

    public void setConnectionSum(String sum) {
        connectionSum.sendKeys(sum);
    }

    public void clickPay() {
        pay.click();
    }
}