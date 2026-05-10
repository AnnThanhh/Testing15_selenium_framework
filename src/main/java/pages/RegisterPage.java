package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends CommonPage {

    //Thuoc tinh (attribute): locators
    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtFullname = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegister = By.className("MuiButton-label");

    //Ham khoi tao
    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Enter account name into account textfield
     * @param accountName
     */
    public void enterAccount(String accountName) {
        inputText(byTxtAccount, accountName);
    }

    public void enterPassword(String password) {
        inputText(byTxtPassword, password);
    }

    public void reEnterPassword(String password) {
        inputText(byTxtConfirmPassword, password);
    }

    public void enterFullName(String fullName) {
        inputText(byTxtFullname, fullName);
    }

    public void enterEmail(String email) {
        inputText(byTxtEmail, email);
    }

    public void clickRegister() {
        click(byBtnRegister);
    }
}
