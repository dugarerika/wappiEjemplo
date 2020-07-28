package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;

public class TestSaveCoupons extends BaseTest {

    @Test
    public void testSaveCouponSuccess() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSaveCouponSuccess",
                "testSaveCouponSuccess");
        objLogIn.logIn("1", objTestReport);
        objCoupons.saveCoupon("1", objTestReport);
        ExtentTestManager.endTest();
    }
}