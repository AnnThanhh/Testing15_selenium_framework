package Base;

import Report.ExtentReportManager;
import drivers.ChromeDriverManager;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {
    //khai báo logger để sử dụng trong các class kế thừa BaseTest
    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void BeforeSuite() {
        LOG.info("Starting before suit - initialize extent report");
        //khởi tạo extent report trước khi chạy bất kỳ testcase nào
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    public void BeforeClass() {
        LOG.info("Starting before class - initialize webdriver");
        DriverManager driverManager = new ChromeDriverManager();
        driverManager.createWebDriver();

        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @BeforeMethod
    //lưu ý: phải khởi tạo report trong before suit trước khi gọi createTest này
    public void BeforeMethod(Method method) {
        LOG.info("Starting before method - create test in extent report" + method.getName());
        //khởi tạo testcase trong extent rerport
        //getName() trả về tên của method đang được gọi
        //ví dụ: nếu method đang được gọi là test_valid_register() thì sẽ trả về "test_valid_register"
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void AfterMethod(ITestResult testResult) {
        LOG.info("Starting after method - check test result and capture screenshot if failed" + testResult.getMethod().getMethodName());
        //kiểm tra testcase có status là fail thì mới thực hiện capture screenshot và ghi lỗi vào extent report
        if(testResult.getStatus() == ITestResult.FAILURE){
            //capsture screenshot khi testcase fail
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), testResult.getMethod().getMethodName());
            //ghi lỗi vào extent report
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
    }

    @AfterClass
    public void AfterClass() {
        LOG.info("Starting after class - quit webdriver" );
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null){
            driver.quit();
        }
        DriverFactory.removeDriver();
    }

    @AfterSuite
    public void AfterSuite() {
        LOG.info("Starting after suit - flush extent report");
        //kết thúc và ghi dữ liệu vào file report sau khi chạy xong tất cả testcase
        ExtentReportManager.flushReports();
        LOG.info("---------Suite finished---------");
    }
}
