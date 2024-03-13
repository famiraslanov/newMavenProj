package elements;
import browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.DriverUtils;

public abstract class BaseElement {

    protected final By locator;

    public BaseElement(By locator){
        this.locator = locator;
    }

    public void Click(){
        DriverManager.getDriver().findElement(this.locator).click();
    }
}
