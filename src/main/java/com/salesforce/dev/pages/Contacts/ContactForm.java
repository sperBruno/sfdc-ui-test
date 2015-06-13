package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactForm {

    private WebDriver driver;
    private WebDriverWait wait;

    private String firstNameRole, firstName, lastName, accountName, title, department, reportsTo, phone, homePhone, mobile, otherPhone, fax, email, assistant, assistantPhone;
    private String mailingStreet, mailingCity, mailingState, mailingZip, mailingCountry, otherStreet, otherCity, otherState, otherZip, otherCountry;
    private String	languages;
    private String description;
    private String birthDate;
    private String leadSource, level;

    //Contact Information

    @FindBy(name = "name_salutationcon2")
    private WebElement firstNameRoleSelect;

    @FindBy(name = "name_firstcon2")
    private WebElement firstNameFld;

    @FindBy(name = "name_lastcon2")
    private WebElement lastNameFld;

    @FindBy(name = "con4") // lupita
    private WebElement accountNameFld;

    @FindBy(id = "con5")
    private WebElement titleFld;

    @FindBy(id = "con6")
    private WebElement departmentFld;

    @FindBy(id = "con7") // calendar
    private WebElement birthDayFld;

    @FindBy(id = "con8") //lupita
    private WebElement reportsToFld;

    @FindBy(id = "con9")
    private WebElement leadSourceSelect;

    @FindBy(id = "con10")
    private WebElement phoneFld;

    @FindBy(id = "con13")
    private WebElement homePhoneFld;

    @FindBy(id = "con12")
    private WebElement mobileFld;

    @FindBy(id = "con14")
    private WebElement otherPhoneFld;

    @FindBy(id = "con11")
    private WebElement faxFld;

    @FindBy(id = "con15")
    private WebElement emailFld;

    @FindBy(id = "con16")
    private WebElement assistantFld;

    @FindBy(id = "con17")
    private WebElement assistantPhoneFld;

    //Address Information

    @FindBy(id = "con19street")
    private WebElement mailingStreetFld;

    @FindBy(id = "con19city")
    private WebElement mailingCityFld;

    @FindBy(id = "con19state")
    private WebElement mailingStateFld;

    @FindBy(id = "con19zip")
    private WebElement mailingZipFld;

    @FindBy(id = "con19country")
    private WebElement mailingCountryFld;

    @FindBy(id = "con18street")
    private WebElement otherStreetFld;

    @FindBy(id = "con18city")
    private WebElement otherCityFld;

    @FindBy(id = "con18state")
    private WebElement otherStateFld;

    @FindBy(id = "con18zip")
    private WebElement otherZipFld;

    @FindBy(id = "con18country")
    private WebElement otherCountryFld;

    // Additional Information

    @FindBy(id = "00N1a0000057MRs")
    private WebElement languagesFld;

    @FindBy(id = "00N1a0000057MRt") // select
    private WebElement levelFld;

    // Description Information

    @FindBy(id = "con20")
    private WebElement descriptionFld;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    public ContactForm(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        try {
            wait.withTimeout(10, TimeUnit.SECONDS)
                    .until(ExpectedConditions.visibilityOf(saveBtn));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            wait.withTimeout(15, TimeUnit.SECONDS);
        }
    }

    public ContactForm(ContactBuilder builder) {

        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

        this.firstNameRole = builder.getFirstNameRole();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.accountName = builder.getAccountName();
        this.title = builder.getTitle();
        this.department = builder.getDepartment();
        this.birthDate = builder.getBirthDate();
        this.reportsTo = builder.getReportsTo();
        this.leadSource = builder.getLeadSource();
        this.phone = builder.getPhone();
        this.homePhone = builder.getHomePhone();
        this.mobile = builder.getMobile();
        this.otherPhone = builder.getOtherPhone();
        this.fax = builder.getFax();
        this.email = builder.getEmail();
        this.assistant = builder.getAssistant();
        this.assistantPhone = builder.getAssistantPhone();

        this.mailingStreet = builder.getMailingStreet();
        this.mailingCity = builder.getMailingCity();
        this.mailingState = builder.getMailingState();
        this.mailingZip = builder.getMailingZip();
        this.mailingCountry = builder.getMailingCountry();
        this.otherCity = builder.getOtherCity();
        this.otherState = builder.getOtherState();
        this.otherZip = builder.getOtherZip();
        this.otherCountry = builder.getOtherCountry();

        this.languages = builder.getLanguages();
        this.level = builder.getLevel();

        this.description = builder.getDescription();
    }

    public ContactDetail saveContact() {

        if(firstName!= null) {
            modifyWebElement(firstNameFld, firstName);
        }
        if(lastName != null) {
            modifyWebElement(lastNameFld, lastName);
        }
        if(accountName != null) {
            modifyWebElement(accountNameFld, accountName);
        }
        if(title != null ) {
            modifyWebElement(titleFld, title);
        }
        if(department != null) {
            modifyWebElement(departmentFld, department);
        }
        if(birthDate!= null) {
            modifyWebElement(birthDayFld, birthDate);
        }
        if(reportsTo!= null) {
            modifyWebElement(reportsToFld, reportsTo);
        }
        // TODO: this is an select
        if(leadSource!= null) {
            modifyWebElement(leadSourceSelect, leadSource);
        }
        if(phone!= null) {
            modifyWebElement(phoneFld, phone);
        }
        if(homePhone!= null) {
            modifyWebElement(homePhoneFld, homePhone);
        }
        if(mobile!= null) {
            modifyWebElement(mobileFld, mobile);
        }
        if(otherPhone!= null) {
            modifyWebElement(otherPhoneFld, otherPhone);
        }
        if(fax!= null) {
            modifyWebElement(faxFld, fax);
        }
        if(email!= null) {
            modifyWebElement(emailFld, email);
        }
        if(assistant!= null) {
            modifyWebElement(assistantFld, assistant);
        }
        if(assistantPhone!= null) {
            modifyWebElement(assistantPhoneFld, assistantPhone);
        }
        if(mailingStreet!= null) {
            modifyWebElement(mailingStreetFld, mailingStreet);
        }
        if(mailingCity!= null) {
            modifyWebElement(mailingCityFld, mailingCity);
        }
        if(mailingState!= null) {
            modifyWebElement(mailingStateFld, mailingState);
        }
        if(mailingZip!= null) {
            modifyWebElement(mailingZipFld, mailingZip);
        }
        if(mailingCountry!= null) {
            modifyWebElement(mailingCountryFld, mailingCountry);
        }
        if(otherCity!= null) {
            modifyWebElement(otherCityFld, otherCity);
        }
        if(otherState!= null) {
            modifyWebElement(otherStateFld, otherState);
        }
        if(otherZip!= null) {
            modifyWebElement(otherZipFld, otherZip);
        }
        if(otherCountry!= null) {
            modifyWebElement(otherCountryFld, otherCountry);
        }
        if(languages!= null) {
            modifyWebElement(languagesFld, languages);
        }
        if(level!= null) {
            modifyWebElement(levelFld, level);
        }
        if(description!= null) {
            modifyWebElement(descriptionFld, description);
        }
        return clickSaveBtn();
    }

    private void modifyWebElement(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    public ContactDetail clickSaveBtn() {
        saveBtn.click();
        return new ContactDetail(driver);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
