package pages;

import Base.BasePage;
import Constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonDialog extends BasePage {
    //thuộc tính
    private By byLblMsg = By.id("swal2-title");
    private By byBtnAgree = By.xpath("//button[text()='Đóng']");
    public CommonDialog (WebDriver driver){
        super(driver);
    }
    //phương thức
    public String getMsg(){
      return getText(byLblMsg);
    };

    public void clickBtnAgree(){
        click(byBtnAgree);
    }

    public void waitForDialogDisappear(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOutConstants.TIME_OUT_DEFAULT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblMsg));
    }
}
