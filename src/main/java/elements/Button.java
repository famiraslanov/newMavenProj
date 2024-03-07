package elements;

import browser.Singletone;
import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(By webElement) {
        super(webElement);
    }

    public void Click(){
        Singletone.getDriver().findElement(this.locator).click();
    }
}
