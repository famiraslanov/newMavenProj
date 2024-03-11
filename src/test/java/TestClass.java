import browser.Singletone;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.CryptoProfile;
import pages.MainPage;
import pages.PricesPage;
import utils.ApiUtils;
import utils.JsonUtils;
import utils.SettingsConstants;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

public class TestClass {

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        Singletone.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
        Singletone.getDriver().manage().window().maximize();
    }

    @Test
    public void testMethod(){
        Singletone.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
        Singletone.getDriver().manage().window().maximize();

        ///Preconditions
        var randomCryptoPair = JsonUtils.getRandomCryptoPair(ApiUtils.getResponse(JsonUtils.getJsonValue(SettingsConstants._endpointsFile, SettingsConstants._krakenAssetsEndpoint))
                , SettingsConstants._1inch);
        var altname = randomCryptoPair.get(SettingsConstants._altname);
        var lastString = JsonUtils.getLastStringFromJsonObject(ApiUtils.getResponse(
           JsonUtils.getJsonValue(SettingsConstants._endpointsFile, SettingsConstants._tradePrice),
           altname.toString(),
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
        ));



        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");

        mainPage.clickPricesButton();
        PricesPage pricesPage = new PricesPage();
        Assert.assertTrue(pricesPage.isPageOpened(), "Prices page is not opened");

        pricesPage.searchForCrypto(altname.toString());
        pricesPage.clickCryptoProfile(altname.toString().toLowerCase(Locale.ROOT));

        var cryptoProfilePage = new CryptoProfile();
        Assert.assertTrue(cryptoProfilePage.isPageOpened(), "Crypto profile pae is not opened");
        cryptoProfilePage.click24hButton();

        Assert.assertNotNull(lastString, "Last string is null");
        Assert.assertFalse(lastString.isEmpty(), "Last string is empty");

        Singletone.getDriver().quit();
    }

    @AfterTest
    public static void tearDown() {
        Singletone.driver.quit();
    }

}
