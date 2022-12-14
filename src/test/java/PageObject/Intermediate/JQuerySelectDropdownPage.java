package PageObject.Intermediate;

import Utility.GenericsMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JQuerySelectDropdownPage extends GenericsMethods {

    WebDriver driver;

    public JQuerySelectDropdownPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Drop Down with Search box*************

    @FindBy(xpath = "//span[@aria-labelledby='select2-country-container']")
    @CacheLookup
    private WebElement selectCountryDropDown;

    @FindBy(className = "select2-results__option")
    @CacheLookup
    private List<WebElement> listOfCountry;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    @CacheLookup
    private WebElement selectedCountry;

    //*************Select Multiple Values*************

    @FindBy(xpath = "//input[@placeholder='Select state(s)']")
    @CacheLookup
    private WebElement selectListOfStates;


    @FindBy(xpath= "//li[@class='select2-selection__choice']")
    @CacheLookup
    private List<WebElement> selectedStates;

    //*************DropDown with Disabled values*************

    @FindBy(xpath= "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    @CacheLookup
    private WebElement dropDownWithDisablesValues;

    @FindBy(xpath= "//select[@class='js-example-disabled-results select2-hidden-accessible']/option")
    @CacheLookup
    private List<WebElement> dropDownWithDisablesValuesList;

    //*************DropDown with Category related options*************

    @FindBy(id = "files")
    @CacheLookup
    private WebElement dropDownWithCategory;

    @FindBy(xpath= "//select[@id='files']/optgroup/option")
    @CacheLookup
    private List<WebElement> dropDownWithDCategoryList;
    //*************Drop Down with Search box*************

    public void clickSelectCountryDropDown() {
        selectCountryDropDown.click();
    }

    public List<WebElement> getListOfCountry() {
        return listOfCountry;
    }

    public WebElement getSelectedCountry(){
        return selectedCountry;
    }
    //*************Select Multiple Values*************

    public void selectElement(String text){
        selectListOfStates.click();
        selectListOfStates.sendKeys(text);
        selectListOfStates.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSelectedStates() {
        return selectedStates;
    }

    //*************DropDown with Disabled values*************
    public void getValueFromDropdownWithDisabledValues(String text){
        selectDropDown(dropDownWithDisablesValues,text);
    }

    public List<WebElement> getListOFDropdownWithDisabledValues(){
        return dropDownWithDisablesValuesList;
    }

    //*************DropDown with Category related options*************

    public void getValueFromDropdownWithCategory(String text){
        selectDropDown(dropDownWithCategory,text);
    }

    public List<WebElement> getListOFDropdownWithCategory(){
        return dropDownWithDCategoryList;
    }
}
