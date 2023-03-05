package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericsMethods {

    WebDriver driver;

    public GenericsMethods(WebDriver driver) {
        this.driver = driver;
    }


    public static void selectDropDown(WebElement dropDownMenu,String text){
        Select select = new Select(dropDownMenu);
        List<WebElement> options = select.getOptions();

        try {
            for (WebElement element1 : options) {
                if (element1.getText().equalsIgnoreCase(text)) {
                    select.selectByVisibleText(text);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    public static String getAlertText(WebDriver driver){
       return driver.switchTo().alert().getText();
    }


    public void dragAndDropBy(WebElement elementToDragAndDrop,int offSetX,int offSetY){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementToDragAndDrop,offSetX,offSetY).build().perform();
    }

}
