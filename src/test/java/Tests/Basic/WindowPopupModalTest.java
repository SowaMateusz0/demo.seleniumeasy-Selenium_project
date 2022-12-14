package Tests.Basic;

import PageObject.Basic.HomePage;
import PageObject.Basic.WindowPopupModalPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WindowPopupModalTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test(dataProvider = "getDataSingle")
    public void validateWindowPopupTitle(String buttonText,String actualURL1,String actualURL2) {

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,5);
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);

        if(buttonText.equalsIgnoreCase("Follow on Twitter")){

         windowPopupModalPage.clickFollowOnTwitterButton();
         Set<String> windowsIDs = driver.getWindowHandles();
         Iterator<String> iterator = windowsIDs.iterator();
         iterator.next();
         String ID1 = iterator.next();
         driver.switchTo().window(ID1);
         Assert.assertEquals(driver.getCurrentUrl(),actualURL1);

      }
         else if(buttonText.equalsIgnoreCase("Like us On Facebook")){

             windowPopupModalPage.clickLikeUsOnFacebookButton();
             Set<String> windowsIDs = driver.getWindowHandles();
             Iterator<String> iterator = windowsIDs.iterator();
             iterator.next();
             String ID1 = iterator.next();
             driver.switchTo().window(ID1);
             Assert.assertEquals(driver.getCurrentUrl(),actualURL1);

            }
         else if(buttonText.equalsIgnoreCase("Follow Twitter & Facebook")){

            Set<String> websitesURL1 = new HashSet<>();
            websitesURL1.add(actualURL1);
            websitesURL1.add(actualURL2);

            windowPopupModalPage.clickFollowTwitterAndFacebook();

            Set<String> windowsID = driver.getWindowHandles();
            Iterator<String> iterator = windowsID.iterator();
            iterator.next();
            String ID1 = iterator.next();
            String ID2 = iterator.next();


            driver.switchTo().window(ID1);
            final String secondURLWebsite = driver.getCurrentUrl();
            driver.switchTo().window(ID2);
            final String thirdURLWebsite = driver.getCurrentUrl();

            Set<String> websitesURL = new HashSet<>();

            websitesURL.add(secondURLWebsite);
            websitesURL.add(thirdURLWebsite);

            Assert.assertEquals(websitesURL,websitesURL1);
        }
   }



    @DataProvider
    public Object[][] getDataSingle() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\WindowPopupModalDataProvider.xlsx";
        return testData(path, 0);
    }

}
