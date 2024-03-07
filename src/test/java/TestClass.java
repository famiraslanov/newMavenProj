import browser.Singletone;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MainPage;
import utils.ApiUtils;
import utils.JsonUtils;
import utils.SettingsConstants;

public class TestClass {

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        Singletone.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
        Singletone.getDriver().manage().window().maximize();
    }

    @Test
    public void testMethod(){
//        Singletone.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
//        Singletone.getDriver().manage().window().maximize();
//
//        MainPage mainPage = new MainPage();
//        mainPage.clickPricesButton();
//
//        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
//
//        Singletone.driver.quit();
        ApiUtils.getRandomCryptoPair();
    }

    @AfterTest
    public static void tearDown() {
        Singletone.driver.quit();
    }

}
