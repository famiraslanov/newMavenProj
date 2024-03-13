package pages;

import browser.DriverManager;
import elements.Button;
import org.openqa.selenium.By;
import utils.DriverUtils;

public class CryptoProfile extends BasePage {
    static Button value24h = new Button(By.xpath("//p[contains(text(), '24H High' )]"));
    public CryptoProfile() {
        super(By.xpath("//p[contains(text(), '24H High' )]"));
    }

    public void click24hButton(){
        DriverUtils.waitForPageLoad();
        value24h.Click();
    }
}
