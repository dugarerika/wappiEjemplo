package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import pom.LogOut;

public class TestLogIn extends BaseTest {
    public LogOut objLogOut = new LogOut();

    @Test(priority = 0, description = "Valid LogIn scenario with correct username and password.")
    public void testLogInSuccess() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInSuccess",
                "Valid LogIn scenario with correct username and password.");
        objLogIn.logIn("1", objTestReport);
        objLogOut.logOut(objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 1, description = "Invalid LogIn scenario empty username.")
    public void testLogInErrorMessageRequiredUserName() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageRequiredUserName",
                "Invalid LogIn scenario empty username.");
        objLogIn.logIn("2", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 2, description = "Invalid login scenario username less than six characters.")
    public void testLogInErrorMessageUserNameLessThanSixCharacters() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageUserNameLessThanSixCharacters",
                "Invalid login scenario username less than six characters.");
        objLogIn.logIn("3", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 3, description = "Invalid login scenario username greater than twenty characters.")
    public void testLogInErrorMessageUserNameGreaterThanTwentyCharacters() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageUserNameGreaterThanTwentyCharacters",
                "Invalid login scenario username greater than twenty characters.");
        objLogIn.logIn("4", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 4, description = "Invalid login scenario username with special characters.")
    public void testLogInErrorMessageUsernameSpecialCharacters() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageUsernameSpecialCharacters",
                "Invalid login scenario username with special characters.");
        objLogIn.logIn("5", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 5, description = "Invalid LogIn scenario empty password.")
    public void testLogInErrorMessageRequiredPassword() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageRequiredPassword",
                "Invalid LogIn scenario empty password.");
        objLogIn.logIn("6", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 6, description = "Invalid login scenario username less than eight characters.")
    public void testLogInErrorMessagePasswordLessThanEightCharacters() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessagePasswordLessThanEightCharacters",
                "Invalid login scenario username less than eight characters.");
        objLogIn.logIn("7", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 7, description = "Invalid login scenario username greater than fourteen characters.")
    public void testLogInErrorMessagePasswordGreaterThanCharacters() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessagePasswordGreaterThanCharacters",
                "Invalid login scenario username greater than fourteen characters.");
        objLogIn.logIn("8", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 8, description = "Invalid login scenario empty username and password.")
    public void testLogInErrorMessageUserNameAndPasswordRequired() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testLogInErrorMessageUserNameAndPasswordRequired",
                "Invalid login scenario empty username and password.");
        objLogIn.logIn("9", objTestReport);
        ExtentTestManager.endTest();
    }
}