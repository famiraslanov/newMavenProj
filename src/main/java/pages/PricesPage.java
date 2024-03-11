package pages;

import browser.Singletone;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;
import utils.ElementsUtils;

import java.sql.Driver;

public class PricesPage  extends BasePage{

    By inputCryptoPlaceholder = By.xpath("//input[contains(@placeholder, 'Search all')]");
    By value24h = By.xpath("//p[contains(text(), '24H High' )]");
    public PricesPage() {
        super(By.xpath("//span[contains(text(), 'Crypto prices')]"));
    }

    public void searchForCrypto(String cryptoName){
        DriverUtils.scrollThePageUntilElementFound(Singletone.getDriver().findElement(inputCryptoPlaceholder));
        Singletone.getDriver().findElement(inputCryptoPlaceholder).sendKeys(cryptoName);
    }

    public void clickCryptoProfile(String cryptoProfileName){
        DriverUtils.getWebDriverWait(2000).until(ExpectedConditions.visibilityOfElementLocated(ElementsUtils.getCryptoPairLocatorDynamically(cryptoProfileName)));
        Singletone.getDriver().findElement(ElementsUtils.getCryptoPairLocatorDynamically(cryptoProfileName)).click();
    }
}
