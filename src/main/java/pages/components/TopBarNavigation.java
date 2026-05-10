package pages.components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopBarNavigation extends BasePage {

    private By byLnkRegister = By.linkText("Đăng Ký");
    private By byLnkLogin = By.linkText("Đăng Nhập");

    public TopBarNavigation(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterPage() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement lnkRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkRegister));
//        lnkRegister.click();
        click(byLnkRegister);
    }

    public void navigateToLoginPage() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement lnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
//        lnkLogin.click();
        click(byLnkLogin);
    }
}
