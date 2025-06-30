package com.huubng.automation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Guru99Test {

    private static WebDriver myBrowser;

    // DDT: DATA DRIVEN TESTING
    public static Object[][] initData() {
        return new Object[][]{
                {"mngr625782", "rAnaqEp"},
                {"mngr625784", "pYmYget"},
                {"mngr625786", "gApUjUb"},
        };
    }
    
    @Test
    void testSearchTGDDGivenKeywordShowsList() {
        myBrowser.get("https://www.thegioididong.com/");
        
        WebElement searchBox = myBrowser.findElement(By.xpath("//input[@id='skw']"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();
                
    }

    @ParameterizedTest
    @MethodSource("initData")
    void testLoginGivenRightAccountsSaysHello(String username, String password) throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/V4");

        WebElement userTextbox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        userTextbox.sendKeys(username);

        WebElement passTextbox = myBrowser.findElement(By.xpath("//input[@name='password']"));
        passTextbox.sendKeys(password);

        WebElement loginButton = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        loginButton.click();

        WebElement welcomeMessage = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        String actual = welcomeMessage.getText();
        String expected = "Manger Id : " + username;

        Thread.sleep(2000);

        assertEquals(expected, actual);
    }

    @Test
    void testLoginGivenRightAccountSaysHello() throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/V4");

        String username = "mngr625784";
        String password = "pYmYget";

        WebElement userTextbox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        userTextbox.sendKeys(username);

        WebElement passTextbox = myBrowser.findElement(By.xpath("//input[@name='password']"));
        passTextbox.sendKeys(password);

        WebElement loginButton = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        loginButton.click();

        // KIỂM TRA XEM ĐÃ ĐĂNG NHẬP THÀNH CÔNG CHƯA
        // THÀNH CÔNG TỨC LÀ CÓ CÂU CHÀO, Manger Id...
        // DÙNG MẮT MÀ NHÌN KO HAY
        // DÙNG CODE SO SÁNH GIÚP THÌ MỚI HAY
        // SO SÁNH BẰNG JNUNIT

        // TÌM TAG CÂU CHÀO TRONG SAU LOGIN
        WebElement welcomeMessage = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        String actual = welcomeMessage.getText();
        String expected = "Manger Id : " + username;
        // KỸ THUẬT LẤY DATA, CRAWL, CRAWLER
        // WEB SO SÁNH ĐI CÀO / LẤY DATA CỦA CÁC TRANG WEB BÁN HÀNG
        // GIÁ IPHONE CỦA TGDD, FPT, CELLPHONES... CẤT VÀO DB RIÊNG

        // KHI CHUYỂN TRANG PHẢI DELAY 1 TÍ ĐỂ TRANG TẢI XONG RỒI MỚI LẤY DATA
        // DO CODE NHANH HƠN TRANG TẢI
        // CỰC KÌ QUAN TRỌNG CỦA NGHỀ CODE TỰ ĐỘNG
        Thread.sleep(2000);

        assertEquals(expected, actual); // XÀI KÉ JUNIT
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

    // 3 CÁCH ĐỂ TEST RUN: - DÀNH CHO DÂN QA / QC
    // CÁCH 1: LÀM BẰNG TAY TOÀN BỘ CÁC BƯỚC Ở TRÊN, TAY LÀM MẮT SOI
    //          MANUAL TEST
    
    // CÁCH 2: CHẠY BẰNG MÁY TOÀN BỘ CÁC BƯỚC TRÊN - SELENIUM
    //          DÒM ĐÚNG SAI XANH ĐỎ = JUNIT
    //          AUTOMATED TEST
    
    // CÁCH 3: RECORD & PLAYBACK / REPLAY
    //          DÂN QC THAO TÁC TEST APP = TAY, CÓ TOOL GHI LẠI HẾT THAO TÁC TEST TAY
    //          GHI MÀN HÌNH -> THÔNG LỆ RA VIDEO
    //          GHI MÀN HÌNH -> RA TẬP LỆNH THEO TOOL (CODE GIẢ)
    //          PLAY TẬP LỆNH NÀY TỰ ĐỘNG LÀM LẠI MỌI THAO TAC MÌNH ĐÃ LÀM BẰNG TAY
    
    // NHÓM TOOL NÀY GỌI LÀ AUTOMATION / AUTOMATED TESTING TOOLS
    // TOOL HUYỀN THOẠI:
    //     KATALON
    //     TEST COMPLETE, RANOREX, TELERIK, ... AKA TEST (FSOFT)
    //     CYPRESS (JS),....
    // AUTOMATION TESTING TOOLS, E2E AUTOMATION TESTING TOOLS
    
    // TẤT CẢ CÁC TOOL NÀY SAU KHI RECORD XOMG,PLAY LẠI ĐỂ KIỂM TRA TEST CASE
    // CÓ THỀ THAY THẾ DATA TRÊN KỊCH BẢN RECORD ĐỂ PHÙ HỢP VỚI DATA MỚI
    // CÓ THỀ EXPORT RA FILE CODE ĐỂ LÀM TIẾP CHO CHỦ ĐỘNG
    // TỪ RECORD -> RA CODE
    // TỪ CODE -> KO RA ĐC RECORD
    
    // TOOL XỊN Ở TRÊN CÓ CỚ CHẾ DDT TRÊN FILE EXCEL, CSV CHỨA DATA
    // TOOL TỰ ĐỘNG LẤY DATA TRÊN FILE EXCEL, CSV ĐỂ THAY THẾ DATA TRONG KỊCH BẢN

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