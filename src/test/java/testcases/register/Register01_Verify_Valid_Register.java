package testcases.register;

import Base.BaseTest;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonDialog;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Register01_Verify_Valid_Register extends BaseTest {

    @Test
    public void test_valid_register() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn"); // home page
        //khai bao WebDriverWait
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

        //khai bao FluentWait
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)); // set time out chờ
        wait.pollingEvery(Duration.ofSeconds(1)); // sau bao lâu kiểm tra lại
        wait.ignoring(NoSuchElementException.class); // khai báo exception bỏ qua

        //Khai bao page object
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Pre-condition: User is on Register page
        //Click on 'Đăng Ký' link on the top right
        homePage.getTopBarNavigation().navigateToRegisterPage();

        //Step 1: Enter account on 'Tài Khoản' textbox
        String accountName = UUID.randomUUID().toString(); // 32 ky tu
        String email = accountName + "@example.com";
        System.out.println("Account: " + accountName);
        System.out.println("Email: " + email);

        //khai bao locator kieu By (chưa tìm element)
        registerPage.enterAccount(accountName);

        //Step 2: Enter password
        String password = "123456";
        registerPage.enterPassword(password);

        //Step 3: Re-enter password
        registerPage.reEnterPassword(password);

        //Step 4: Enter fullname
        registerPage.enterFullName("John Johnson");

        //Step 5: Enter email
        registerPage.enterEmail(email);

        //Step 6: Click register
        registerPage.clickRegister();

        //Step 7: Verify valid register successfully
        //VP1 (Verify Point 1): 'Đăng Ký thành công' message displays
        CommonDialog commonDialog = new CommonDialog(driver);
        String recordedRegisterMsg = commonDialog.getMsg();
        Assert.assertEquals(recordedRegisterMsg, "Đăng ký thành công", "Register text message failed !");

        //Wait message dialog disappear
//        commonDialog.waitForDialogDisappear();
        //Click 'Đồng ý' button on message dialog
        commonDialog.clickBtnAgree();

        //VP2: Login successfully with registered account
        //Click 'Dang Nhap' link
        registerPage.getTopBarNavigation().navigateToLoginPage();

        //Enter account to login
        loginPage.enterAccount(accountName);

        //Enter password to login
        loginPage.enterPassword(password);

        //Click 'Dang Nhap' button
        loginPage.clickLogin();

        //VP: 'Đăng nhập thành công' message displays
        String recordedLoginMsg = commonDialog.getMsg();
        Assert.assertEquals(recordedLoginMsg, "Đăng nhập thành công", "Login text message failed !");

//        driver.quit(); // Close browser & Quit chromedriver process
    }

}
