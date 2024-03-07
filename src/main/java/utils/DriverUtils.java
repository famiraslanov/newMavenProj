package utils;//package utils;

import browser.Singletone;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils {
    private DriverUtils(){

    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(Singletone.getDriver(), Duration.ofSeconds(3));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
