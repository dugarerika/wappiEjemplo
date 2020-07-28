package pom;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.LogStatus;
import extentreports.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import data.DataDriven;
import exceptions.IncorrectDataDrivenValues;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import toolsandutilities.Utilities;

public class LogIn {
    private static final By TXTUSERNAME = By.xpath("//input[@id='username']");
    private static final By TXTPASSWORD = By.xpath("//input[@id='password']");
    private static final By BTNLOGIN = By.xpath("//button[@id='button-login']");
    private static final By ERRORMESSAGEUSERNAME = By.id("e-username");
    private static final By ERRORMESSAGEPASSWORD = By.id("e-password");
    private static final By LBLOFFER = By.xpath("//*[contains(text(),'Ofertas')]");

    public LogIn logIn(String strId, ExtentTest objTestReport) throws IncorrectDataDrivenValues, FilloException {
        DataDriven objDataDriven = new DataDriven();
        Recordset objRecordset = objDataDriven.searchRecords
                ("src/test/resources/data/DataDriven.xlsx", "SELECT * FROM Users WHERE IdUsers = '" + strId + "'");
        Utilities.type(TXTUSERNAME, objRecordset.getField("UserName"));
        Utilities.type(TXTPASSWORD, objRecordset.getField("Password"));
        Utilities.el(TXTPASSWORD).sendKeys(Keys.TAB);

        if (Utilities.isElementPresent(ERRORMESSAGEUSERNAME)){
            verifyErrorMessageUserName(objTestReport, ERRORMESSAGEUSERNAME);
        }

        if (Utilities.isElementPresent(ERRORMESSAGEPASSWORD)){
            verifyErrorMessagePassword(objTestReport, ERRORMESSAGEPASSWORD);
        }

        Utilities.click(BTNLOGIN);

        if (Utilities.isElementPresent(LBLOFFER)){
            objTestReport.log(LogStatus.PASS, "LogIn test passed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public LogIn verifyErrorMessageUserName(ExtentTest objTestReport, By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("El usuario es requerido".equals(strErrorMessage) ||
                "El usuario debe contener entre 6 y 20 caracteres".equals(strErrorMessage) ||
                "El usuario debe ser alfanumérico".equals(strErrorMessage)){
            objTestReport.log(LogStatus.PASS, "Message validation username successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation username failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

    public LogIn verifyErrorMessagePassword(ExtentTest objTestReport,By by){
        String strErrorMessage = Utilities.getText(by).trim();

        if ("La contraseña es requerida".equals(strErrorMessage) ||
                "La contraseña debe contener entre 8 y 14 caracteres".equals(strErrorMessage)){
            objTestReport.log(LogStatus.PASS, "Message validation successful: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Message validation failed: '" + strErrorMessage + "'",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        return this;
    }

}