package Tests;

import Pages.HomePage;
import Tests.TestBase;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductHoverMenueTest extends TestBase {

    HomePage homeObject;

@Test
    public void UserCanSelectSubCategroyFromManiMenue(){
        homeObject=new HomePage(driver);
        homeObject.SelectNoteBookMenue();
    }
   
}
