package pom;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import data.DataDriven;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import toolsandutilities.Utilities;
import java.awt.*;

public class UpdateProfile {
    private static final String STRPATHIMAGES = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
    private static final By LNKPROFILE = By.xpath("//app-home/app-nav-bar/nav/ul[@class='nav-bar-menu']/li[3]/a");
    private static final By BTNSELECTFILE = By.xpath("//*[@id='image' and @label='Imagen']");
    private static final By TXTNAME = By.xpath("//*[@id='name' and @type='text']");
    private static final By TXTLASTNAME = By.xpath("//*[@id='lastName' and @type='text']");
    private static final By TXTDATEOFBIRTH = By.xpath("//*[@id='bornDate' and @type='text']");
    private static final By CMBCOUNTRY = By.xpath("//*[@id='country' and @data-cy='country']");
    private static final By CHKMALE = By.xpath("//*[@id='Male' and @data-cy='Male']");
    private static final By CHKFEMALE = By.xpath("//*[@id='Female' and @data-cy='Female']");
    private static final By BTNSAVE = By.id("save-profile");
    private static final By ERRORMESSAGEIMAGE = By.id("e-image");
    private static final By ERRORMESSAGENAME = By.id("e-name");
    private static final By ERRORMESSAGELASTNAME = By.id("e-lastname");
    private static final By ERRORMESSAGEDATEOFBIRTH = By.id("e-bornDate");
    private static final By ERRORMESSAGECOUNTRY = By.id("e-country");
    private static final By ERRORMESSAGEGENDER = By.id("e-genre");

    public UpdateProfile updateProfile(String strId, ExtentTest objTestReport) throws AWTException, IncorrectDataDrivenValues, FilloException {
        DataDriven objDataDriven = new DataDriven();
        Recordset objRecordset = objDataDriven.searchRecords
                ("src/test/resources/data/DataDriven.xlsx", "SELECT * FROM Users WHERE IdUsers = '" + strId + "'");
        Utilities.click(LNKPROFILE);

        if (!"".equals(objRecordset.getField("NameImageProfile").trim())){
            Utilities.click(BTNSELECTFILE);
            Utilities.wt(2000);
            Utilities.robotSendKeys(STRPATHIMAGES + objRecordset.getField("NameImageProfile"));
        }

        Utilities.type(TXTNAME, objRecordset.getField("Name"));
        Utilities.type(TXTLASTNAME, objRecordset.getField("LastName"));
        Utilities.type(TXTDATEOFBIRTH, objRecordset.getField("DateOfBirth"));

        if (!"".equals(objRecordset.getField("Country").trim())){
            Utilities.selectByVisibleText(CMBCOUNTRY, objRecordset.getField("Country"));
        }

        switch (objRecordset.getField("Gender")) {
            case "Masculino":
                Utilities.click(CHKMALE);
                break;
            case "Femenino":
                Utilities.click(CHKFEMALE);
                break;
            default:
                break;
        }

        objTestReport.log(LogStatus.PASS, "Data typed in the test" ,
                ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        Utilities.click(BTNSAVE);

        if (Utilities.isElementPresent(ERRORMESSAGEIMAGE)){
            verifyErrorMessaImage(objTestReport, ERRORMESSAGEIMAGE);
        }

        if (Utilities.isElementPresent(ERRORMESSAGENAME)){
            verifyErrorMessaName(objTestReport, ERRORMESSAGENAME);
        }

        if (Utilities.isElementPresent(ERRORMESSAGELASTNAME)){
            verifyErrorMessaLastName(objTestReport, ERRORMESSAGELASTNAME);
        }

        if (Utilities.isElementPresent(ERRORMESSAGEDATEOFBIRTH)){
            verifyErrorMessaDateOfBirth(objTestReport, ERRORMESSAGEDATEOFBIRTH);
        }

        if (Utilities.isElementPresent(ERRORMESSAGECOUNTRY)){
            verifyErrorMessaCountry(objTestReport, ERRORMESSAGECOUNTRY);
        }

        if (Utilities.isElementPresent(ERRORMESSAGEGENDER)){
            verifyErrorMessaGender(objTestReport, ERRORMESSAGEGENDER);
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaImage(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("La imagen es requerida".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation image successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation image failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaName(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("El nombre es requerido".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation name successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation name failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaLastName(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("El apellido es requerido".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation last name successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation last name failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaDateOfBirth(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("La fecha de nacimiento es requerida".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation date of birth successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation date of birth failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaCountry(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("El país es requerido".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation country successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation country failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public UpdateProfile verifyErrorMessaGender(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("El género es requerido".equals(strErrorMessage)) {
            objTestReport.log(LogStatus.PASS, "Message validation gender successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation gender failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }
}