package elements;
import browser.Singletone;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.DriverUtils;

public abstract class BaseElement {

    protected final By locator;

    public BaseElement(By locator){
        this.locator = locator;
    }

    public boolean isElementExist() {
        DriverUtils.waitForPageLoad();

        try {
            Singletone.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
