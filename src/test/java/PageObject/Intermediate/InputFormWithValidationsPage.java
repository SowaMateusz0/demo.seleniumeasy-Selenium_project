package PageObject.Intermediate;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InputFormWithValidationsPage extends GenericsMethods {

    WebDriver driver;

    public InputFormWithValidationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Fields*************

    @FindBy(xpath = "//input[@name='first_name']")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='last_name']")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='email']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='phone']")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='address']")
    @CacheLookup
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='city']")
    @CacheLookup
    private WebElement cityField;

    @FindBy(xpath = "//select[@name='state']")
    @CacheLookup
    private WebElement state;

    @FindBy(xpath = "//input[@name='zip']")
    @CacheLookup
    private WebElement zip;

    @FindBy(xpath = "//input[@name='website']")
    @CacheLookup
    private WebElement website;

    @FindBy(xpath = "//input[@name='hosting']")
    @CacheLookup
    private List<WebElement> radioBox;

    @FindBy(xpath = "//textarea[@name='comment']")
    @CacheLookup
    private WebElement comment;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    @CacheLookup
    private WebElement sendButton;

    //*************Text*************

    @FindBy(xpath = "//label[text()='First Name']")
    @CacheLookup
    private WebElement firstNameText;

    @FindBy(xpath = "//label[text()='Last Name']")
    @CacheLookup
    private WebElement lastNameText;

    @FindBy(xpath = "//label[text()='E-Mail']")
    @CacheLookup
    private WebElement emailText;

    @FindBy(xpath = "//label[text()='Phone #']")
    @CacheLookup
    private WebElement phoneText;

    @FindBy(xpath = "//label[text()='Address']")
    @CacheLookup
    private WebElement addressText;

    @FindBy(xpath = "//label[text()='City']")
    @CacheLookup
    private WebElement cityText;

    @FindBy(xpath = "//label[text()='State']")
    @CacheLookup
    private WebElement stateText;

    @FindBy(xpath = "//label[text()='Zip Code']")
    @CacheLookup
    private WebElement zipCodeText;

    @FindBy(xpath = "//label[text()='Website or domain name']")
    @CacheLookup
    private WebElement websiteText;

    @FindBy(xpath = "//label[text()='Do you have hosting?']")
    @CacheLookup
    private WebElement hosting;


    @FindBy(xpath = "//label[text()='Project Description']")
    @CacheLookup
    private WebElement descriptionText;

    //*************Error Messages*************

    @FindBy(xpath = "//small[@data-bv-result='INVALID']")
    @CacheLookup
    private List<WebElement> errorMessages;




    //*************Fields*************

    public void enterFirstName(String text){
        firstNameField.sendKeys(text);
    }

    public void enterLastName(String text){
        lastNameField.sendKeys(text);
    }

    public void enterEmail(String text){
        emailField.sendKeys(text);
    }

    public void enterPhone(String text){
        phoneField.sendKeys(text);
    }

    public void enterAddress(String text){
        addressField.sendKeys(text);
    }

    public void enterCity(String text){
        cityField.sendKeys(text);
    }

    public void chooseState(WebElement state, String stateName){
        selectDropDown(state, stateName);
    }

    public WebElement getState(){
        return state;
    }

    public void enterZipCode(String text){
        zip.sendKeys(text);
    }

    public void enterWebsite(String text){
        website.sendKeys(text);
    }

    public void doYouWantHaveHostingRadioBox(int index){
        radioBox.get(index).click();
    }

    public void enterComment(String text){
        comment.sendKeys(text);
    }

    //*************Text*************

    public WebElement getFirstNameText(){
        return firstNameText;
    }

    public WebElement getLastNameText(){
        return lastNameText;
    }

    public WebElement getEmailText(){
        return emailText;
    }

    public WebElement getPhoneText(){
        return firstNameText;
    }

    public WebElement getAddressText(){
        return addressText;
    }

    public WebElement getCityTextText(){
        return cityText;
    }

    public WebElement getStateText(){
        return stateText;
    }

    public WebElement getZipCodeText(){
        return zipCodeText;
    }

    public WebElement getWebsiteText(){
        return websiteText;
    }

    public WebElement getHostingText(){
        return hosting;
    }

    public WebElement getDescriptionText(){
        return descriptionText;
    }

    public List<WebElement> getRadioBox(){
        return radioBox;
    }

    //*************Error Messages*************

    public List<WebElement> getErrorMessages(){
        return errorMessages;
    }

}
