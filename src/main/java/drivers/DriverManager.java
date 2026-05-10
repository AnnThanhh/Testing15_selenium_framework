package drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    public abstract void createWebDriver();

    public WebDriver getDriver(){
        return this.driver;
    }
}
