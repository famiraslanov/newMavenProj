package pages;

import browser.Singletone;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public abstract class BasePage {

    protected final By locator;

    public BasePage(By locator){
        this.locator = locator;
    }
    public boolean isPageOpened() {
        DriverUtils.waitForPageLoad();
        DriverUtils.getWebDriverWait(3000).until(ExpectedConditions.visibilityOfElementLocated(locator));

        try {
            Singletone.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
