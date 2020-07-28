package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import java.awt.*;

public class TestUpdateProfile extends BaseTest{

    @Test(priority = 0, description = "Valid update profile scenario with correct fields.")
    public void testUpdateProfileSuccess() throws AWTException, IncorrectDataDrivenValues, FilloException {
        ExtentTest objTestReport = ExtentTestManager.startTest("testUpdateProfileSuccess",
                "Valid update profile scenario with correct fields");
        objLogIn.logIn("1", objTestReport);
        objUpdateProfile.updateProfile("1", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 1, description = "Invalid update profile scenario with incorrect fields.")
    public void testUpdateProfileFieldsRequired() throws AWTException, IncorrectDataDrivenValues, FilloException {
        ExtentTest objTestReport = ExtentTestManager.startTest("testUpdateProfileSuccess",
                "Invalid update profile scenario with incorrect fields");
        objLogIn.logIn("11", objTestReport);
        objUpdateProfile.updateProfile("12", objTestReport);
        ExtentTestManager.endTest();
    }
}