package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import pom.LogOut;

public class TestOffers extends BaseTest {
    public LogOut objLogOut = new LogOut();

    @Test(priority = 0)
    public void testOfferWithCouponSuccess() throws FilloException, IncorrectDataDrivenValues, InterruptedException {
        ExtentTest objTestReport = ExtentTestManager.startTest("testOfferWithCouponSuccess",
                "testOfferWithCouponSuccess");
        objLogIn.logIn("1", objTestReport);
        objCoupons.saveCoupon("1", objTestReport);
        objOffers.orderProduct("1", "Jamón Premium", objTestReport);
        objLogOut.logOut(objTestReport);
        ExtentTestManager.endTest();
    }
}