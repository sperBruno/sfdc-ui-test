package com.salesforce.dev.pages.Contacts;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.FormBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marcelo.Vargas on 6/12/2015.
 */
public class ContactForm {

    private WebDriver driver;
    private WebDriverWait wait;

    //Contact Information

    @FindBy(name = "name_salutationcon2")
    private WebElement firstNameRoleSelect;

    @FindBy(name = "name_firstcon2")
    private WebElement firstNameFld;

    @FindBy(name = "name_lastcon2")
    private WebElement lastNameFld;

    @FindBy(name = "con4") // lookup
    private WebElement accountNameFld;

    @FindBy(id = "con5")
    private WebElement titleFld;

    @FindBy(id = "con6")
    private WebElement departmentFld;

    @FindBy(id = "con7") // calendar
    private WebElement birthDayFld;

    @FindBy(id = "con8") //lookup
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

    @FindBy(id = "00N1a0000057MRt")
    private WebElement levelSelect;

    // Description Information

    @FindBy(id = "con20")
    private WebElement descriptionFld;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    Select firstNameRoleDropdown, leadSourceDropdown, levelDropdown;

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

    public ContactForm setFirstNameRole(String text) {
        firstNameRoleDropdown = new Select(firstNameRoleSelect);
        firstNameRoleDropdown.selectByVisibleText(text);
        return this;
    }

    public ContactForm setFirstName(String text) {
        firstNameRoleSelect.clear();
        firstNameRoleSelect.sendKeys(text);
        return this;
    }

    public ContactForm setLastName(String text) {
        lastNameFld.clear();
        lastNameFld.sendKeys(text);
        return this;
    }

    public ContactForm setAccountName(String text) {
        accountNameFld.clear();
        accountNameFld.sendKeys(text);
        return this;
    }

    public ContactForm setTitle(String text) {
        titleFld.clear();
        titleFld.sendKeys(text);
        return this;
    }

    public ContactForm setDepartment(String text) {
        departmentFld.clear();
        departmentFld.sendKeys(text);
        return this;
    }

    public ContactForm setBirthDate(String text) {
        birthDayFld.clear();
        birthDayFld.sendKeys(text);
        return this;
    }

    public ContactForm setReportsTo(String text) {
        reportsToFld.clear();
        reportsToFld.sendKeys(text);
        return this;
    }

    public ContactForm setLeadSource(String text) {
        leadSourceDropdown = new Select(leadSourceSelect);
        leadSourceDropdown.selectByVisibleText(text);
        return this;
    }

    public ContactForm setPhone(String text) {
        phoneFld.clear();
        phoneFld.sendKeys(text);
        return this;
    }

    public ContactForm setHomePhone(String text) {
        homePhoneFld.clear();
        homePhoneFld.sendKeys(text);
        return this;
    }

    public ContactForm setMobile(String text) {
        mobileFld.clear();
        mobileFld.sendKeys(text);
        return this;
    }

    public ContactForm setOtherPhone(String text) {
        otherPhoneFld.clear();
        otherPhoneFld.sendKeys(text);
        return this;
    }

    public ContactForm setFax(String text) {
        faxFld.clear();
        faxFld.sendKeys(text);
        return this;
    }

    public ContactForm setEmail(String text) {
        emailFld.clear();
        emailFld.sendKeys(text);
        return this;
    }

    public ContactForm setAssistant(String text) {
        assistantFld.clear();
        assistantFld.sendKeys(text);
        return this;
    }

    public ContactForm setAssistantPhone(String text) {
        assistantPhoneFld.clear();
        assistantPhoneFld.sendKeys(text);
        return this;
    }


    public ContactForm setMailingStreet(String text) {
        mailingStreetFld.clear();
        mailingStreetFld.sendKeys(text);
        return this;
    }

    public ContactForm setMailingCity(String text) {
        mailingCityFld.clear();
        mailingCityFld.sendKeys(text);
        return this;
    }

    public ContactForm setMailingState(String text) {
        mailingStateFld.clear();
        mailingStateFld.sendKeys(text);
        return this;
    }

    public ContactForm setMailingZip(String text) {
        mailingZipFld.clear();
        mailingZipFld.sendKeys(text);
        return this;
    }

    public ContactForm setMailingCountry(String text) {
        mailingCountryFld.clear();
        mailingCountryFld.sendKeys(text);
        return this;
    }

    public ContactForm setOtherCity(String text) {
        otherCityFld.clear();
        otherCityFld.sendKeys(text);
        return this;
    }

    public ContactForm setOtherState(String text) {
        otherStateFld.clear();
        otherStateFld.sendKeys(text);
        return this;
    }

    public ContactForm setOtherZip(String text) {
        otherZipFld.clear();
        otherZipFld.sendKeys(text);
        return this;
    }

    public ContactForm setOtherCountry(String text) {
        otherCountryFld.clear();
        otherCountryFld.sendKeys(text);
        return this;
    }


    public ContactForm setLanguages(String text) {
        languagesFld.clear();
        languagesFld.sendKeys(text);
        return this;
    }

    public ContactForm setLevel(String text) {
        levelDropdown = new Select(levelSelect);
        levelDropdown.selectByVisibleText(text);
        return this;
    }

    public ContactForm setDescription(String text) {
        descriptionFld.clear();
        descriptionFld.sendKeys(text);
        return this;
    }

    public ContactDetail clickSaveBtn() {
        saveBtn.click();
        return new ContactDetail(driver);
    }
}