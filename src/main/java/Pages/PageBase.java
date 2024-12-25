package Pages;

import org.apache.hc.core5.function.Factory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase {
    protected WebDriver driver;
    public JavascriptExecutor jsa;
    public Select select;
    public Actions action;

    //Create constructor
    public PageBase (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
protected static void clickButton(WebElement button)
{
 button.click();
}
protected static void setTextElemnetText
        (WebElement textElement,String Value)
{
    textElement.sendKeys(Value);
}

public void ScrollToButton(){
        jsa.executeScript("scrollBy(0,2500)"); // دا كود بينزلني لاخر البيدج

}


}
