package pages;

import browser.Singletone;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import utils.DriverUtils;

public class CryptoProfile extends BasePage {
    By value24h = By.xpath("//p[contains(text(), '24H High' )]");
    public CryptoProfile() {
        super(By.xpath("//p[contains(text(), '24H High' )]"));
    }

    public void click24hButton(){
        DriverUtils.waitForPageLoad();
        Singletone.getDriver().findElement(value24h).click();
    }
}
