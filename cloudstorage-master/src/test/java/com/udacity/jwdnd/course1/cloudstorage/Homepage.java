package com.udacity.jwdnd.course1.cloudstorage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Homepage {

    @LocalServerPort
    private int port;
    private static WebDriver driver;

//notes
    @FindBy(id = "logoutbtn")
    private WebElement logoutbtn;

    @FindBy(id = "nav-notes-tab")
    private WebElement nottab;

    @FindBy(id="addnotebtn")
    private WebElement addntbtn;

    @FindBy(id="notedtbtn")
    private WebElement noteeditbtn;

    @FindBy(id="notdltbtn")
    private WebElement notdeltbtn;

    @FindBy(id="note-id")
    private WebElement noteid;

    @FindBy(id="note-title")
    private WebElement notetitle;

    @FindBy(id="note-description")
    private WebElement notedescr;

    @FindBy(id="noteSubmit")
    private WebElement notesubmt;

    @FindBy(id="notepopclostbn")
    private WebElement noteppclose;

    @FindBy(id="notesvbtn")
    private WebElement notesavebtn;

    @FindBy(id="noteclsbtn")
    private WebElement noteclosebtn;

//credentials
    @FindBy(id="nav-credentials-tab")
    private WebElement credtabnav;

    @FindBy(id="addcredentials")
    private WebElement addcredt;

    @FindBy(id="credential-url")
    private WebElement credurl;

    @FindBy(id="credential-password")
    private WebElement credpass;

    @FindBy(id="credclose")
    private WebElement creadclos;

    @FindBy(id="credsave")
    private WebElement creadsave;

    @FindBy(id="credential-username")
    private WebElement creduser;

    @FindBy(id="crededit")
    private WebElement crededit;

    @FindBy(id="creddelete")
    private WebElement creddelete;


    public Homepage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public WebElement getLogoutbtn() {
        return logoutbtn;
    }

    public WebElement getNottab() {
        return nottab;
    }

    public WebElement getAddntbtn() {
        return addntbtn;
    }

    public WebElement getNoteeditbtn() {
        return noteeditbtn;
    }

    public WebElement getNotdeltbtn() {
        return notdeltbtn;
    }

    public WebElement getNoteid() {
        return noteid;
    }

    public WebElement getNotetitle() {
        return notetitle;
    }

    public WebElement getNotedescr() {
        return notedescr;
    }

    public WebElement getNotesubmt() {
        return notesubmt;
    }

    public WebElement getNoteppclose() {
        return noteppclose;
    }

    public WebElement getNotesavebtn() {
        return notesavebtn;
    }

    public WebElement getNoteclosebtn() {
        return noteclosebtn;
    }

//////////////////////////

    public WebElement getCredtab() {
        return credtabnav;
    }

    public WebElement getAddcredt() {
        return addcredt;
    }

    public WebElement getCredurl() {
        return credurl;
    }

    public WebElement getCredpass() {
        return credpass;
    }

    public WebElement getCreadclos() {
        return creadclos;
    }

    public WebElement getCreadsave() {
        return creadsave;
    }

    public WebElement getCredtabnav() {
        return credtabnav;
    }

    public WebElement getCreduser() {
        return creduser;
    }

    public WebElement getCrededit() {
        return crededit;
    }

    public WebElement getCreddelete() {
        return creddelete;
    }

//helper method home test
    public void attempetLogout() throws InterruptedException {

        Thread.sleep(500);
        logoutbtn.click();
    }

//helper method home Create note
    public void attempetcreatenote(String notetitlevalue ,String notedescrvalue) throws InterruptedException {

        nottab.click();
        Thread.sleep(500);
        addntbtn.click();
        Thread.sleep(500);
        notetitle.clear();
        notetitle.sendKeys(notetitlevalue);
        Thread.sleep(500);
        notedescr.clear();
        notedescr.sendKeys(notedescrvalue);
        Thread.sleep(500);
        notesavebtn.click();
        Thread.sleep(500);
    }
// helper for Edit note
    public void attempettoedit(String notetitlevalue , String notedescrvalue) throws InterruptedException {

        nottab.click();
        Thread.sleep(500);
        noteeditbtn.click();
        Thread.sleep(500);
        notetitle.clear();
        notetitle.sendKeys(notetitlevalue);
        Thread.sleep(500);
        notedescr.clear();
        notedescr.sendKeys(notedescrvalue);
        Thread.sleep(500);
        notesavebtn.click();
        Thread.sleep(500);
    }

// Helper Method For Delete Note
        public void attempttodeletenote() throws InterruptedException {

        nottab.click();
        Thread.sleep(500);
        notdeltbtn.click();
    }

//helper method home sigup sigin note and credential
        public void attempetcreatecred(String credtitlevalue ,String creuservalue,String creddescrvalue) throws InterruptedException {

        credtabnav.click();
        Thread.sleep(500);
        addcredt.click();
        Thread.sleep(500);
        credurl.clear();
        credurl.sendKeys(credtitlevalue);
        Thread.sleep(500);
        creduser.clear();
        creduser.sendKeys(creuservalue);
        credpass.clear();
        credpass.sendKeys(creddescrvalue);
        Thread.sleep(500);
        creadsave.click();
        Thread.sleep(500);
    }

//helper method home sigup sigin note and credential
        public void attempettoeditcred(String credtitlevalue ,String creuservalue,String creddescrvalue) throws InterruptedException {

        credtabnav.click();
        Thread.sleep(500);
        crededit.click();
        Thread.sleep(500);
        credurl.clear();
        credurl.sendKeys(credtitlevalue);
        Thread.sleep(500);
        creduser.clear();
        creduser.sendKeys(creuservalue);
        credpass.clear();
        credpass.sendKeys(creddescrvalue);
        Thread.sleep(500);
        creadsave.click();
        Thread.sleep(500);
    }


// Helper Method For Delete Note
        public void attempttodeletecred() throws InterruptedException {

         credtabnav.click();
         Thread.sleep(500);
         creddelete.click();
    }

}
