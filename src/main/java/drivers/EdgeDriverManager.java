package drivers;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        this.driver = new EdgeDriver();
    }
}
