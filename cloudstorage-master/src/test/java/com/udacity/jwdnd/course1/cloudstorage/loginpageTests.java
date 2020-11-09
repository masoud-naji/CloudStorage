package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class loginpageTests {

    String eerrlogin="Invalid username or password";

    @LocalServerPort
    private int port;
    private static WebDriver driver;
    private Loginpage loginpage;




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
        driver.get("http://localhost:"+port+"/login");
        loginpage = new Loginpage(driver);
    }

    @Test //home without loging cant access
    public void withoutLoginPage() throws InterruptedException {
        driver.get("http://localhost:" + this.port + "/home");
        Thread.sleep(500);
        Assertions.assertEquals("Login", driver.getTitle());
    }


    @Test //logintest
    public void testLogin() throws InterruptedException {
        loginpage.attempetLogin("User1","pass1");
        Thread.sleep(500);
        Assertions.assertEquals(eerrlogin,loginpage.getErrmsg().getText());
    }

    @Test
    public void getLoginPage() throws InterruptedException {
        driver.get("http://localhost:" + this.port + "/signup");
        Thread.sleep(500);
        Assertions.assertEquals("Sign Up", driver.getTitle());
    }



}
