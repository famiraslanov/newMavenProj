package pages;

import browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;
import utils.ElementsUtils;

public class PricesPage  extends BasePage{

    By inputCryptoPlaceholder = By.xpath("//input[contains(@placeholder, 'Search all')]");
    public PricesPage() {
        super(By.xpath("//span[contains(text(), 'Crypto prices')]"));
    }

    public void searchForCrypto(String cryptoName){
        DriverUtils.scrollThePageUntilElementFound(DriverManager.getDriver().findElement(inputCryptoPlaceholder));
        DriverManager.getDriver().findElement(inputCryptoPlaceholder).sendKeys(cryptoName);
    }

    public void clickCryptoProfile(String cryptoProfileName){
        DriverUtils.getWebDriverWait(2000).until(ExpectedConditions.visibilityOfElementLocated(ElementsUtils.getCryptoPairLocatorDynamically(cryptoProfileName)));
        DriverManager.getDriver().findElement(ElementsUtils.getCryptoPairLocatorDynamically(cryptoProfileName)).click();
    }
}
