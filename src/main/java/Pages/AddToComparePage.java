package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddToComparePage extends PageBase{
    public AddToComparePage(WebDriver driver){
        super(driver);

    }
    @FindBy(css = "compare-products-table")
    WebElement compareTable;

    @FindBy(tagName = "td")
    List<WebElement>allCol;

    @FindBy(tagName = "tr")
    List<WebElement>allRows;

    @FindBy(css = "clear-list")
    WebElement clearBtn;
    @FindBy(css="no-data")
    public WebElement messageOfClear;
    @FindBy(linkText = "Digital Storm VANQUISH 3 Custom Performance PC")
    public WebElement firstProductName;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement secondProductName;

    public void ClearCompareList(){
        clickButton(clearBtn);
    }
    public void UserCanAddProductToCompareList(){
        //get all data of row
        System.out.println(allRows.size());
        //Get data for each row
        for (WebElement row:allRows){
            System.out.println(row.getText()+"t");
            for (WebElement table:allCol){
                System.out.println(table.getText()+"t");
            }

        }
    }

    }

