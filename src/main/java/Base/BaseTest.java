package Base;

import drivers.ChromeDriverManager;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    @BeforeClass
    public void BeforeClass() {
        DriverManager driverManager = new ChromeDriverManager();
        driverManager.createWebDriver();

        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @AfterClass
    public void AfterClass() {
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null){
            driver.quit();
        }
        DriverFactory.removeDriver();
    }


}
