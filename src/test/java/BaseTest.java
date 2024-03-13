import browser.DriverManager;
import org.testng.annotations.BeforeMethod;
import utils.JsonUtils;
import utils.SettingsConstants;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        DriverManager.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageUrl));
        DriverManager.getDriver().manage().window().maximize();
    }
}
