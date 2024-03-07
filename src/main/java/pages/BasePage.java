package pages;

import browser.Singletone;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.DriverUtils;

public abstract class BasePage {

    protected final By locator;

    public BasePage(By locator){
        this.locator = locator;
    }
    public boolean isPageOpened() {
        DriverUtils.waitForPageLoad();

        try {
            Singletone.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
