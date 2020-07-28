package pom;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import toolsandutilities.Utilities;

public class LogOut {
    private static final By LNKLOGOUT = By.xpath("//app-home/app-nav-bar/nav/ul[@class='nav-bar-account']/li[2]/a");
    private static final By TXTUSERNAME = By.xpath("//input[@id='username']");

    public LogOut logOut (ExtentTest objTestReport){
        Utilities.click(LNKLOGOUT);

        if (Utilities.isElementPresent(TXTUSERNAME)){
            objTestReport.log(LogStatus.PASS, "LogOut test passed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));

        }

        return this;
    }
}