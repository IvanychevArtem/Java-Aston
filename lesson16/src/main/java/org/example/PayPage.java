package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayPage {

    public PayPage(WebDriver driver, WebElement frameLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='creditCard']")));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'pay-description__cost')]//span[1]")
    private WebElement payFrameDescriptionCost;

    @FindBy(xpath = "//div[contains(@class, 'card-page__card')]//button")
    private WebElement payFrameBtn;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__text')]//span[1]")
    private WebElement payFrameDescriptionPhone;

    @FindBy(xpath = "//div[contains(@class, 'cards-brands')]//img")
    private List<WebElement> payImages;

    @FindBy(xpath = "//input[@formcontrolname='creditCard']/following-sibling::label")
    private WebElement creditCardPlaceholder;

    @FindBy(xpath = "//input[@formcontrolname='expirationDate']/following-sibling::label")
    private WebElement expirationDatePlaceholder;

    @FindBy(xpath = "//input[@formcontrolname='cvc']/following-sibling::label")
    private WebElement cvcPlaceholder;

    @FindBy(xpath = "//input[@formcontrolname='holder']/following-sibling::label")
    private WebElement cardHolderPlaceholder;

    public String getPayFrameDescriptionCost() {
        return payFrameDescriptionCost.getText();
    }

    public String getPayFrameBtnText() {
        return payFrameBtn.getText();
    }

    public String getPayFrameDescriptionPhone() {
        return payFrameDescriptionPhone.getText();
    }

    public boolean isDisplayedImg(String src) {
        for (WebElement payImage : payImages) {
            if (payImage.getAttribute("src").contains(src)) {
                return payImage.isDisplayed() || payImage.getAttribute("style").contains("opacity: 0");
            }
        }
        return false;
    }

    public String getCreditCardPlaceholder() {
        return creditCardPlaceholder.getText();
    }

    public String getExpirationDatePlaceholder() {
        return expirationDatePlaceholder.getText();
    }

    public String getCvcPlaceholder() {
        return cvcPlaceholder.getText();
    }

    public String getCardHolderPlaceholder() {
        return cardHolderPlaceholder.getText();
    }
}
