package pages;

import browser.Singletone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    //WebDriver driver = new ChromeDriver();

    By pricesButton = By.xpath("//a[@href ='/prices' and text() = 'Prices']");

    public MainPage() {
        super(By.xpath("//a[@href = 'https://kraken.app.link/home-hero-ios']"));//appStoreButton
    }


    public void clickPricesButton(){
        Singletone.getDriver().findElement(pricesButton).click();
    }

}
