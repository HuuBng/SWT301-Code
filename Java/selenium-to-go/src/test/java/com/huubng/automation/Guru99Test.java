package com.huubng.automation;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.junit.jupiter.api.Assertions.*;

class Guru99Test {

    private static WebDriver myBrowser;
    
    @Test
    void testLoginGivenRightAccountSaysHello() {
        myBrowser.get("https://demo.guru99.com/V4");

        WebElement userTextbox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        userTextbox.sendKeys("mngr625784");
        
        WebElement passTextbox = myBrowser.findElement(By.xpath("//input[@name='password']"));
        passTextbox.sendKeys("pYmYget");
        
        WebElement loginButton = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        loginButton.click();
        
        WebElement welcomeMessage = myBrowser.findElement(By.xpath("//td[normalize-space()='Manger Id : mngr625784']"));
        String string = welcomeMessage.getText();
        
        assertEquals("Manger Id : mngr625784", string, "The welcome message should match the expected text.");
        
    }
    // Test case #1: Test login page with valid manager account
    //          Steps:
    //              1. Open a certain browser, e.g. Chrome
    //              2. Type url: https://demo.guru99.com/V4
    //              3. Type a valid manager account: mngr625784 / pYmYget 
    //              4. Hit enter to login 
    
    // Expected Result:
    //              2. The login page is displayed including account form shown in the center
    //              4. The welcome message is shown under the format
    //                  Manger Id: <user-id>, e.g.
    //                  Manger Id: mngr625784
    
    // 2 CÁCH ĐỂ TEST RUN:
    // CÁCH 1: LÀM BẰNG TAY TOÀN BỘ CÁC BƯỚC Ở TRÊN, TAY LÀM MẮT SOI
    //          MANUAL TEST
    // CÁCH 2: CHẠY BẰNG MÁY TOÀN BỘ CÁC BƯỚC TRÊN - SELENIUM
    //          DÒM ĐÚNG SAI XANH ĐỎ = JUNIT
    //          AUTOMATED TEST
    
    @BeforeAll // hàm này sẽ chạy trước tất cả @Test
    // Dùng để khởi động biến, tập tin data (DDT từ Excel, .csv)
    static void setUp() {
        System.setProperty("webdriver.edgedriver.driver", "msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        myBrowser = new EdgeDriver(options);
        myBrowser.manage().window().maximize();
        
    }

    @AfterAll // hàm này sẽ chạy sau tất cả các @Test
    static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        myBrowser.quit();
    }
}