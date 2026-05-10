package drivers;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager{
    @Override
    public void createWebDriver() {
        this.driver = new SafariDriver();
    }
}
