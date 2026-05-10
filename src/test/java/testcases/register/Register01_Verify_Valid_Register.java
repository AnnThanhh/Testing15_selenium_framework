package testcases.register;

import Base.BaseTest;
import Report.ExtentReportManager;
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
        ExtentReportManager.info("bước 1: mở trình duyệt và truy cập và trang Demo1");
        LOG.info("bước 1: mở trình duyệt và truy cập và trang Demo1");
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
        ExtentReportManager.info("bước 2: click vào link 'Đăng Ký' trên thanh điều hướng");
        LOG.info("bước 2: click vào link 'Đăng Ký' trên thanh điều hướng");
        homePage.getTopBarNavigation().navigateToRegisterPage();
        ExtentReportManager.info("bước 3: nhập thông tin hợp vào form đăng ký");
        LOG.info("bước 3: nhập thông tin hợp vào form đăng ký");
        //Step 1: Enter account on 'Tài Khoản' textbox
        String accountName = UUID.randomUUID().toString(); // 32 ky tu
        String email = accountName + "@example.com";
        System.out.println("Account: " + accountName);
        System.out.println("Email: " + email);

        ExtentReportManager.info("bước 4: nhập thông tin hợp vào ô tài khoản");
        LOG.info("bước 4: nhập thông tin hợp vào ô tài khoản");
        //khai bao locator kieu By (chưa tìm element)
        registerPage.enterAccount(accountName);

        ExtentReportManager.info("bước 5: nhập thông tin hợp vào ô mật khẩu");
        LOG.info("bước 5: nhập thông tin hợp vào ô mật khẩu");
        //Step 2: Enter password
        String password = "123456";
        registerPage.enterPassword(password);

        ExtentReportManager.info("bước 6: nhập thông tin hợp vào ô nhập lại mật khẩu");
        LOG.info("bước 6: nhập thông tin hợp vào ô nhập lại mật khẩu");
        //Step 3: Re-enter password
        registerPage.reEnterPassword(password);

        ExtentReportManager.info("bước 7: nhập thông tin hợp vào ô nhập lại họ tên");
        LOG.info("bước 7: nhập thông tin hợp vào ô nhập lại họ tên");
        //Step 4: Enter fullname
        registerPage.enterFullName("John Johnson");

        ExtentReportManager.info("bước 8: nhập thông tin hợp vào ô nhập lại email");
        LOG.info("bước 8: nhập thông tin hợp vào ô nhập lại email");
        //Step 5: Enter email
        registerPage.enterEmail(email);

        ExtentReportManager.info("bước 9: click vào button 'Đăng Ký'");
        LOG.info("bước 9: click vào button 'Đăng Ký'");
        //Step 6: Click register
        registerPage.clickRegister();

        //Step 7: Verify valid register successfully
        //VP1 (Verify Point 1): 'Đăng Ký thành công' message displays
        ExtentReportManager.info("bước 10: kiểm tra message 'Đăng Ký thành công' hiển thị");
        LOG.info("bước 10: kiểm tra message 'Đăng Ký thành công' hiển thị");
        CommonDialog commonDialog = new CommonDialog(driver);
        String recordedRegisterMsg = commonDialog.getMsg();
        Assert.assertEquals(recordedRegisterMsg, "Đăng ký thành công", "Register text message failed !");

        //Wait message dialog disappear
//        commonDialog.waitForDialogDisappear();
        ExtentReportManager.info("bước 11: click vào button 'Đóng' trên message dialog");
        LOG.info("bước 11: click vào button 'Đóng' trên message dialog");
        //Click 'Đồng ý' button on message dialog
        commonDialog.clickBtnAgree();

        //VP2: Login successfully with registered account
        ExtentReportManager.info("bước 12: click vào link 'Đăng Nhập' trên thanh điều hướng");
        LOG.info("bước 12: click vào link 'Đăng Nhập' trên thanh điều hướng");
        //Click 'Dang Nhap' link
        registerPage.getTopBarNavigation().navigateToLoginPage();

        ExtentReportManager.info("bước 13: nhập thông tin hợp lệ vào ô tài khoản");
        LOG.info("bước 13: nhập thông tin hợp lệ vào ô tài khoản");
        //Enter account to login
        loginPage.enterAccount(accountName);

        ExtentReportManager.info("bước 14: nhập thông tin hợp lệ vào ô mật khẩu");
        LOG.info("bước 14: nhập thông tin hợp lệ vào ô mật khẩu");
        //Enter password to login
        loginPage.enterPassword(password);

        ExtentReportManager.info("bước 15: click vào button 'Đăng Nhập'");
        LOG.info("bước 15: click vào button 'Đăng Nhập'");
        //Click 'Dang Nhap' button
        loginPage.clickLogin();

        //VP: 'Đăng nhập thành công' message displays
        ExtentReportManager.info("bước 16: kiểm tra message 'Đăng Nhập thành công' hiển thị");
        LOG.info("bước 16: kiểm tra message 'Đăng Nhập thành công' hiển thị");
        String recordedLoginMsg = commonDialog.getMsg();
        Assert.assertEquals(recordedLoginMsg, "Đăng nhập thành công!", "Login text message failed !");

//        driver.quit(); // Close browser & Quit chromedriver process
    }

}
