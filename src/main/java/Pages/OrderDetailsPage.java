package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class OrderDetailsPage extends PageBase{

    public OrderDetailsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "button-2.print-order-button")
    WebElement printBtn;

    @FindBy(css = "button-2.pdf-invoice-button")
    WebElement pdfInvoiceBtn;

    public void PrintOrderDetails(){
        clickButton(printBtn);
    }

    public void DownloadPdfInvoice(){
        clickButton(pdfInvoiceBtn);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

}
