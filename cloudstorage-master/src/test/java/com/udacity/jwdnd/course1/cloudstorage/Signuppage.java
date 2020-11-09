package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signuppage {

    @FindBy(id = "inputFirstName")
    private WebElement firstnameinp;

    @FindBy(id = "inputLastName")
    private WebElement lastnameinp;

    @FindBy(id = "inputUsername")
    private WebElement usernameinp;

    @FindBy(id = "inputPassword")
    private WebElement passinp;

    @FindBy(id = "subbtn")
    private WebElement subbutton;

    @FindBy(id = "success-msg")
    private WebElement sucssmsg;

    @FindBy(id = "loginlink")
    private WebElement loginlink;


    public Signuppage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public WebElement getFirstnameinp() {
        return firstnameinp;
    }

    public WebElement getLastnameinp() {
        return lastnameinp;
    }

    public WebElement getUsernameinp() {
        return usernameinp;
    }

    public WebElement getPassinp() {
        return passinp;
    }

    public WebElement getSubbutton() {
        return subbutton;
    }

    public WebElement getSucssmsg() {
        return sucssmsg;
    }

    public WebElement getLoginlink() {
        return loginlink;
    }



    //helper method
    public void attempetSignup(String firstnamevalue,String lastnamevalue,String usernamenamevalue,String passwordValue) throws InterruptedException {
        firstnameinp.clear();
        firstnameinp.sendKeys(firstnamevalue);
        Thread.sleep(500);
        lastnameinp.clear();
        lastnameinp.sendKeys(lastnamevalue);
        Thread.sleep(500);
        usernameinp.clear();
        usernameinp.sendKeys(usernamenamevalue);
        Thread.sleep(500);
        passinp.clear();
        passinp.sendKeys(passwordValue);
        Thread.sleep(500);
        subbutton.click();
        Thread.sleep(500);
        loginlink.click();


    }
}
