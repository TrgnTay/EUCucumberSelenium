package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends com.vytrack.pages.BasePage {
//if we extend BasePage in order to initialise webelement we dont need separate constructor

    //since we are extending BasePage we do not need explicit constructor for this class(in BasePage there is constructor)

     //@FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    //public WebElement email;

    @FindBy(css=".input-widget")
    public WebElement pageNumber;

     public WebElement getContactEmail(String email){   //we have one method which returns webElement for the email
         //if we don't use singleton Driver, we can add Webdriver driver like (Webdriver driver,String eamil){ 3:12:45 jamal video day16

         String xpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";

          return Driver.get().findElement(By.xpath(xpath));

     }
}
