import Models.ResponseData;
import browser.DriverManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.CryptoProfile;
import pages.MainPage;
import pages.PricesPage;
import utils.ApiUtils;
import utils.EndpointUtils;
import utils.JsonUtils;
import utils.SettingsConstants;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

public class TestClass extends BaseTest{

    @Test
    public void testMethod() throws JsonProcessingException {
        DriverManager.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
        DriverManager.getDriver().manage().window().maximize();

        ///Preconditions
        var inchCryptoPair = EndpointUtils.getRandomCryptoPair(ApiUtils.getResponse(JsonUtils.getJsonValue(SettingsConstants._endpointsFile, SettingsConstants._krakenAssetsEndpoint))
                , SettingsConstants._1inch);
        var altname = inchCryptoPair.get(SettingsConstants._altname);

        var lastString = EndpointUtils.getLastStringFromJsonObject(ApiUtils.getResponse(
                JsonUtils.getJsonValue(SettingsConstants._endpointsFile, SettingsConstants._tradePrice)
                        + "pair=" + altname.toString() + "USD&since=" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + "&count=1"));

        var responseJson = ApiUtils.getResponse(
                JsonUtils.getJsonValue(SettingsConstants._endpointsFile, SettingsConstants._tradePrice)
                + "pair=" + altname.toString() + "USD&since=" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + "&count=1"

        );

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseData.Result responseData = objectMapper.readValue(responseJson, ResponseData.Result.class);
        ResponseData.Result results = responseJson.readEntity(ResponseData.class).getResults();

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
        Assert.assertFalse(lastString.isEmpty(), "Last string is null");

        DriverManager.getDriver().quit();
    }

    @AfterTest
    public static void tearDown() {
        DriverManager.driver.quit();
    }

}
