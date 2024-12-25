package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutPage extends PageBase{
    public CheckoutPage (WebDriver driver){
        super(driver);
    }
    @FindBy(id = "BillingNewAddress_CountryId")
    List<WebElement> countryDropDown;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    List <WebElement> stateDropDown;
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityTxt;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressTxtBox;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipTxtBox;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneTxtBox;
    @FindBy(css = "button-1 new-address-next-step-button")
    WebElement continueBtn;
    @FindBy(id = "shippingoption_0")
    WebElement shippingCheckBox;
    @FindBy(id = "paymentmethod_0")
    WebElement paymentCheckBox;
    @FindBy(css = "button-1.confirm-order-next-step-button")
    WebElement confirmaAdressBtn;
    @FindBy(css = "button-1 shipping-method-next-step-button")
    WebElement confirmShippingBtn;
    @FindBy(css = "button-1 payment-method-next-step-button")
    WebElement confirmPaymentBtn;
    @FindBy(css = "button-1 payment-info-next-step-button")
    WebElement confirmFinalPaymentBtn;
    @FindBy(css="h1")
    public WebElement sucessMessgae;

    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink;

    public void Checkout(String city,String address,String zip,String phone){
        countryDropDown.get(3).click();
        stateDropDown.get(1).click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        setTextElemnetText(cityTxt,city);
        setTextElemnetText(addressTxtBox,address);
        setTextElemnetText(zipTxtBox,zip);
        setTextElemnetText(phoneTxtBox,phone);
        clickButton(continueBtn);
        clickButton(shippingCheckBox);
        clickButton(paymentCheckBox);
        clickButton(confirmaAdressBtn);
        clickButton(confirmShippingBtn);
        clickButton(confirmPaymentBtn);
        clickButton(confirmFinalPaymentBtn);
    }
    public void OpenOrderDetailsPage(){
        clickButton(orderDetailsLink);
    }
}
