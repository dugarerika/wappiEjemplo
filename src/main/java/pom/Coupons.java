package pom;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import data.DataDriven;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import toolsandutilities.Utilities;

public class Coupons {
    private static final By BTNCOUPON = By.xpath("//app-home/app-nav-bar/nav/ul[@class='nav-bar-account']/li[1]/button");
    private static final By LBLCOUPONCODE = By.id("coupon-code");
    private static final By BTNCLOSEMODAL = By.xpath("//*[@id='coupon-modal']//*[contains(text(),'×')]");

    public Coupons saveCoupon(String strId, ExtentTest objTestReport) throws IncorrectDataDrivenValues {
        DataDriven objDataDriven = new DataDriven();
        String strCouponCode;
        Utilities.click(BTNCOUPON);
        Utilities.waitForElement(LBLCOUPONCODE, 1);
        strCouponCode = Utilities.getText(LBLCOUPONCODE);

        if (Utilities.isElementPresent(LBLCOUPONCODE)){
            objTestReport.log(LogStatus.PASS, "Save coupon successfully",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));

        }

        //update file with coupon.
        objDataDriven.updateRecord("src/test/resources/data/DataDriven.xlsx",
                "UPDATE Users SET WelcomeCouponCode = '" + strCouponCode + "' WHERE IdUsers = '" + strId + "'");
        Utilities.click(BTNCLOSEMODAL);
        return this;
    }
}