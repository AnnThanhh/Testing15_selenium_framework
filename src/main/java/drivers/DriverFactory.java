package drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Phương thức để thiết lập WebDriver cho Thread hiện tại
    public static void setDriverThreadLocal(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    // Phương thức để lấy WebDriver của Thread hiện tại
    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    // Phương thức để xóa WebDriver của Thread hiện tại
    public static void removeDriver(){
        driverThreadLocal.remove();
    }
}
