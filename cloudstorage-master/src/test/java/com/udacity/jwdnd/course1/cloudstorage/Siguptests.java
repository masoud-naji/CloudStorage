package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Siguptests {

    String succmsg = "You successfully signed up! Please continue to the login page.";


    @LocalServerPort
    private int port;
    private static WebDriver driver;
    private Signuppage signuppage;
    private Loginpage loginpage;
    private Homepage homepage;


    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/signup");
        signuppage = new Signuppage(driver);
    }

    @Test
    public void testSignup() throws InterruptedException {

//Test signup
        signuppage.attempetSignup("firstname1", "lastname1", "Username1", "pass2");
        Assertions.assertEquals(succmsg, signuppage.getSucssmsg().getText());
        Thread.sleep(50);


//Test Login
        driver.get("http://localhost:" + port + "/login");
        loginpage = new Loginpage(driver);
        loginpage.attempetLogin("Username1", "pass2");
        Thread.sleep(50);


//Test Homw page
        driver.get("http://localhost:" + this.port + "/home");
        homepage = new Homepage(driver);
        Thread.sleep(50);
        Assertions.assertEquals("Home", driver.getTitle());
//Create Note
        Thread.sleep(500);
        homepage.attempetcreatenote("Note title test 1", "Note test 1");
        Thread.sleep(500);//Test result back
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Edit Note
        Thread.sleep(500);
        homepage.attempettoedit("Note Edit title test 1", "Note Edit test 1");
        Thread.sleep(500);//Test result back
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Delete note
        Thread.sleep(500);
        homepage.attempttodeletenote();
        Thread.sleep(500);
        Alert confirm = driver.switchTo().alert();
        confirm.accept();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Add Cred
        Thread.sleep(500);
        homepage.attempetcreatecred("Cred name", "Cred user", "Credpass");
        Thread.sleep(500);//Test result back
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Edit Cred
        Thread.sleep(500);
        homepage.attempettoeditcred("Cred Edit name2", "Cred Edit user2", "Cred Edit pass2");
        Thread.sleep(500);//Test result back
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Delete Cred
        Thread.sleep(500);
        homepage.attempttodeletecred();
        Thread.sleep(500);
        Alert confirm2 = driver.switchTo().alert();
        confirm2.accept();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href='/home']")).click();
//Logout Test
        Thread.sleep(5500);
        homepage.getLogoutbtn();
//Test Homw page after log out
        driver.get("http://localhost:" + this.port + "/home");
        homepage = new Homepage(driver);
        Thread.sleep(500);
        Assertions.assertNotEquals("login", driver.getTitle());
    }
}
