package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    @FindBy(id="inputUsername")
    private WebElement username;

    @FindBy(id="inputPassword")
    private  WebElement password;

    @FindBy(id="submit-button")
    private  WebElement loginbt;

    @FindBy(id="signup-link")
    private  WebElement signuplnk;

    @FindBy(id="error-msg")
    private  WebElement errmsg;




    public Loginpage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginbt() {
        return loginbt;
    }

    public WebElement getSignuplnk() {
        return signuplnk;
    }

    public WebElement getErrmsg() {
        return errmsg;
    }


//helper method login
    public void attempetLogin(String usernameValue,String passwordValue) throws InterruptedException {
        username.clear();
        username.sendKeys(usernameValue);
        Thread.sleep(500);
        password.clear();
        password.sendKeys(passwordValue);
        Thread.sleep(500);
        loginbt.click();

    }
}
