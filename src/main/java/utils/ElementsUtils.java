package utils;

import org.openqa.selenium.By;

public class ElementsUtils {
    private ElementsUtils(){

    }

    public static By getCryptoPairLocatorDynamically(String locatorAttribute){
        return  By.xpath("//a[contains(@href, '" + locatorAttribute + "')]") ;
    }
}
