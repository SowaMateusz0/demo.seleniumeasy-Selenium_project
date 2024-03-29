package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.GenericsMethods.selectDropDown;
import static Utility.WaitForElement.waitUntilElementIsVisible;

public class SelectDropdownListPage{

    protected WebDriver driver;

    public SelectDropdownListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Select List Demo*************

    @FindBy(xpath = "//select[@id='select-demo']/option[position()>1]")
    @CacheLookup
    private List<WebElement> selectListDemo;

    @FindBy(id = "select-demo")
    @CacheLookup
    private WebElement singleList;

    @FindBy(className = "selected-value")
    @CacheLookup
    private WebElement outputTextSingleDropDownList;

    //*************Multi Select List Demo*************

    @FindBy(xpath = "//select[@id='multi-select']/option")
    private List<WebElement> allElementsFromMultiSelectList;

    @FindBy(xpath = "//select[@id='multi-select']")
    private WebElement ListOfMultiSelectDropDown;

    @FindBy(id = "printMe")
    @CacheLookup
    private WebElement firstSelectedButton;

    @FindBy(id = "printAll")
    @CacheLookup
    private WebElement getAllSelectedButton;

    @FindBy(className = "getall-selected")
    @CacheLookup
    private WebElement getOutputTextMultiSelectDropDownList;

    public WebElement listOfAllDays(){
        waitUntilElementIsVisible(singleList,driver);
        return singleList;
    }

    public String getOutputTextFromSingleSelectDropDownList(){
        waitUntilElementIsVisible(outputTextSingleDropDownList,driver);
        return outputTextSingleDropDownList.getText();
    }

    public SelectDropdownListPage selectElementFromDropDownMenu(WebElement element,String visibleText){
        waitUntilElementIsVisible(element,driver);
        selectDropDown(element,visibleText);
        return this;
    }

    public WebElement getGetAllSelectedButton() {
        waitUntilElementIsVisible(getAllSelectedButton,driver);
        return getAllSelectedButton;
    }

    public String getGetTextFromMultiSelect() {
        waitUntilElementIsVisible(getOutputTextMultiSelectDropDownList,driver);
        return getOutputTextMultiSelectDropDownList.getText();
    }

    public WebElement getIndexOfElementFromMultiSelectList(int index){
        waitUntilElementIsVisible(allElementsFromMultiSelectList.get(index),driver);
        return allElementsFromMultiSelectList.get(index);
    }
}