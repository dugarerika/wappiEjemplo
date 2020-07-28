package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.LogIn;
import pom.LogOut;
import toolsandutilities.Utilities;

public class TestLogOut {
    private LogIn objLogIn = new LogIn();
    private LogOut objLogOut = new LogOut();

    @BeforeMethod
    public void beforeMethod() {
        Utilities.openUrl("https://wappi.netlify.com/login");
    }

    @Test
    public void testLogOutSuccess() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogOutSuccess",
                "testLogOutSuccess");
        objLogIn.logIn("1", objTestReport);
        objLogOut.logOut(objTestReport);
        ExtentTestManager.endTest();
    }

    @AfterMethod
    public static void closeBrowser() {
        Utilities.closeExplorer();
        Utilities.closeProcess();
    }
}