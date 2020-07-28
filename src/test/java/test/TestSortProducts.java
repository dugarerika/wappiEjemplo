package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import toolsandutilities.Utilities;

public class TestSortProducts extends BaseTest {

    @Test(priority = 0)
    public void testSortDateUp() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortDateUp", "testSortDateUp");
        objLogIn.logIn("1", objTestReport);
//        objLogIn.logInGeneric("1");
        objOffers.sortProducts("Fecha", "Ascendente");
        objTestReport.log(LogStatus.PASS, "SortDateUp test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }

    @Test(priority = 1)
    public void testSortDateDown() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortDateDown", "testSortDateDown");
        objLogIn.logIn("1", objTestReport);
        objOffers.sortProducts("Fecha", "Descendente");
        objTestReport.log(LogStatus.PASS, "SortDateDown test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }

    @Test(priority = 2)
    public void testSortPriceUp() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortPriceUp", "testSortPriceUp");
        objLogIn.logIn("1", objTestReport);
        objOffers.sortProducts("Precio", "Ascendente");
        objTestReport.log(LogStatus.PASS, "SortPriceUp test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }

    @Test(priority = 3)
    public void testSortPriceDown() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortPriceDown", "testSortPriceDown");
        objLogIn.logIn("1", objTestReport);
        objOffers.sortProducts("Precio", "Descendente");
        objTestReport.log(LogStatus.PASS, "SortPriceDown test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }

    @Test(priority = 4)
    public void testSortComerceUp() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortComerceUp", "testSortComerceUp");
        objLogIn.logIn("1", objTestReport);
        objOffers.sortProducts("Comercio", "Ascendente");
        objTestReport.log(LogStatus.PASS, "SortComerceUp test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }

    @Test(priority = 5)
    public void testSortComerceDown() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testSortComerceDown", "testSortComerceDown");
        objLogIn.logIn("1", objTestReport);
        objOffers.sortProducts("Comercio", "Descendente");
        objTestReport.log(LogStatus.PASS, "SortComerceDown test passed",
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        ExtentTestManager.endTest();
    }
}