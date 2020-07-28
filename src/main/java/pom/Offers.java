package pom;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import data.DataDriven;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import toolsandutilities.Utilities;
import java.util.List;

public class Offers {
    private static final By LNKHOME = By.xpath("//app-home/app-nav-bar/nav/ul[@class='nav-bar-menu']/li[1]/a");
    private static final By SORTDATE = By.id("date-order");
    private static final By SORTPRICE = By.id("price-order");
    private static final By SORTCOMERCE = By.id("comerce-order");
    private static final By BTNORDERS = By.className("offers-table-block-button");
    private static final By TXTCOUPONCODE = By.xpath("//*[@id='coupon' and @type='text']");
    private static final By BTNORDERCONFIRM = By.id("order-confirm");
    private static final By BTNCLOSECONFIRMATIONMODAL = By.xpath("//*[@id='confirmation-modal']//*[contains(text(),'×')]");
    private static final By CONFIRMATIONMODAL = By.className("confirmation-modal-info");

    public void tabHome (){
        Utilities.click(LNKHOME);
    }

    public Offers orderProduct (String strId, String strProduct, ExtentTest objTestReport) throws IncorrectDataDrivenValues, FilloException {
        DataDriven objDataDriven = new DataDriven();
        Recordset objRecordset = objDataDriven.searchRecords
                ("src/test/resources/data/DataDriven.xlsx", "SELECT * FROM Users WHERE IdUsers = '" + strId + "'");
        String strWelcomeCouponCode = objRecordset.getField("WelcomeCouponCode").trim();
        String strMessageCouponSuccess = "El cupón " + strWelcomeCouponCode +
                " ha sido utilizado con éxito. Tu pedido ha sido confirmado, te mantendremos informado ante nuevas novedades.";
        List<WebElement> orderList = Utilities.els(BTNORDERS);

        for (WebElement order : orderList){
            By product = By.xpath("//*[contains(text(),'" + strProduct + "')]");

            if (Utilities.isElementPresent(product) && strProduct.equalsIgnoreCase(Utilities.getText(product))){
                order.click();
                objTestReport.log(LogStatus.PASS, "Order product",
                        ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
                break;
            }

        }

        Utilities.waitForElement(TXTCOUPONCODE, 1);

        if ("".equals(strWelcomeCouponCode)){
            Utilities.click(BTNORDERCONFIRM);
        }else{
            Utilities.type(TXTCOUPONCODE, strWelcomeCouponCode);
            objTestReport.log(LogStatus.PASS, "Coupon code typed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
            Utilities.click(BTNORDERCONFIRM);
        }

        Utilities.wt(3500);

        if (strMessageCouponSuccess.equals(Utilities.getText(CONFIRMATIONMODAL).trim())){
            objTestReport.log(LogStatus.PASS, "Offers test passed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Offers test failed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }

        Utilities.click(BTNCLOSECONFIRMATIONMODAL);
        return this;
    }

    public Offers sortProducts(String strSortColumn, String strOrientation){

        switch (strSortColumn) {
            case "Fecha":
                Utilities.waitForElement(SORTDATE,1);
                sortColumns(strOrientation, SORTDATE);
                break;
            case "Precio":
                Utilities.waitForElement(SORTPRICE,1);
                sortColumns(strOrientation, SORTPRICE);
                break;
            case "Comercio":
                Utilities.waitForElement(SORTCOMERCE,1);
                sortColumns(strOrientation, SORTCOMERCE);
                break;
            default:
                break;
        }

        return this;
    }

    public Offers sortColumns(String strOrientation, By by){

        if("Ascendente".equalsIgnoreCase(strOrientation)){

            if(Utilities.isElementPresent(By.className("sort-col-title")) ||
                    Utilities.isElementPresent(By.className("sort-col-title active active-desc"))){
                Utilities.click(by);
            }

        }else {

            if(Utilities.isElementPresent(By.className("sort-col-title"))){
                Utilities.click(by);
                Utilities.click(by);
            }else if(Utilities.isElementPresent(By.className("sort-col-title active"))){
                Utilities.click(by);
            }

        }

        return this;
    }
}