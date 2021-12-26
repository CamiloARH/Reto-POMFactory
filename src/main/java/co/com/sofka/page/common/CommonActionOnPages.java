package co.com.sofka.page.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActionOnPages extends BaseSikulix {
    private final WebDriver driver;
    private final WebDriverWait explicitWait;

    protected CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver,120);
    }


    protected void scrollDown(){
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollBy(0,300)");
    }
    protected void scrollUp(){
        JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
        scrollUp.executeScript("window.scrollBy(1000,0)");
    }

    //Functions WebElement
    protected void  typeInto(WebElement locator, String value){
        locator.sendKeys(value);
    }

    protected void  click(WebElement locator){
        waitToBeClickable(locator);
        locator.click();
    }

    protected void pressEnter(WebElement locator) {locator.sendKeys(Keys.ENTER); }

    protected void scrollTo(WebElement locator){
        JavascriptExecutor scrollTo = (JavascriptExecutor) driver;
        scrollTo.executeScript("arguments[0].scrollIntoView();", locator);
    }

    protected String getText(WebElement locator) {return locator.getText();    }

    protected void waitToBeClickable(WebElement locator){
        this.explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeInvisible(By locator) {
        var element = driver.findElement(locator);
        this.explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }
}
