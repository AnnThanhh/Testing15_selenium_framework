package pages;

import Constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonPage {

    private By byTxtLoginAccount = By.id("taiKhoan");
    private By byTxtLoginPassword = By.id("matKhau");
    private By byBtnLogin = By.xpath("//button[.='Đăng nhập']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterAccount(String accountName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtLoginAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtLoginAccount));
//        txtLoginAccount.sendKeys(accountName);
        inputText(byTxtLoginAccount, accountName);
    }

    public void enterPassword(String password) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement txtLoginPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtLoginPassword));
//        txtLoginPassword.sendKeys(password);
        inputText(byTxtLoginPassword, password);
    }

    public void clickLogin() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
//        btnLogin.click();
        click(byBtnLogin);
    }
}
