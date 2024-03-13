package pages;

import browser.DriverManager;
import elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage{

    Button pricesButton =new Button(By.xpath("//a[@href ='/prices' and text() = 'Prices']"));

    public MainPage() {
        super(By.xpath("//a[@href = 'https://kraken.app.link/home-hero-ios']"));//appStoreButton
    }


    public void clickPricesButton(){
        pricesButton.Click();
    }

}
