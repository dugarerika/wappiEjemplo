package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.*;
import toolsandutilities.Utilities;
import extentreports.ExtentTestManager;

public class BaseTest {
    public WebDriver driver;
    public LogIn objLogIn;
    public Coupons objCoupons;
    public Offers objOffers;
    public UpdateProfile objUpdateProfile;

    @BeforeMethod
    public void methodLevelSetup() {
        Utilities.openUrl("https://wappi.netlify.com/login");
        objLogIn = new LogIn();
        objCoupons = new Coupons();
        objOffers = new Offers();
        objUpdateProfile = new UpdateProfile();
    }

    @AfterMethod
    public void teardown() {
        Utilities.closeExplorer();
        Utilities.closeProcess();
        ExtentTestManager.endTest();
    }
}