package com.huubng.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        // NẠP FILE .EXE VÀO TRONG MÁY ẢO JAVA - TẢI DRIVER/PHẦN MỀM ĐIỀU KHIỀN TRÌNH DUYỆT VÀO 
        // TRONG MÁY ẢO
        // Y CHANG LỆNH Class.forName(jdbc driver ...)
        System.setProperty("webdriver.edgedriver.driver", "msedgedriver.exe");
        
        
        // Trình duyệt ta sẽ mở lên để test app web nào đó
        // Trình duyệt bản thân nó là 1 object trong RAM, 1 app là 1 obj, trình duyệt là
        // object bự...

//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--inprivate");
//        options.addArguments("--lang=ja-JP");
//        WebDriver myBrowser = new EdgeDriver(options);
        WebDriver myBrowser = new EdgeDriver();
        myBrowser.manage().window().maximize(); // mặc định trình duyệt mở 1/2 màn hình
                                                // lệnh này cho full màn hình
        
        
        myBrowser.get("https://google.com");

        WebElement searchBox = myBrowser.findElement(By.name("q"));
        // tìm thẻ tag trong trang google mà có name là "q"
        // ta có thể tìm theo id, class, theo css và theo xpath !!!
        // xpath: kĩ thuật viết câu lệnh query để tìm 1 tag nào đó trong vô số tag đang có
        //      trong page ở RAM trình duyệt
        // TƯỞNG TƯỢNG: BROWSER + TRANG WEB ĐÃ TẢI VỀ MÁY MÌNH LÀ 1 TABLE
        //                                          THÌ DATA TRONG TABLE LÀ CÁC TAG
        // TABLE                BROWSER
        //   ROW                    TAG
        //   ROW                    TAG
        // SQL LẤY ROW              XPATH, ID, NAME, CSS ĐỂ LẤY TAG
        //                          findElementBy(By.???, css, id, name, xpath)
        searchBox.sendKeys("Jack đom đóm");
        searchBox.submit();
        
        // KHÔNG TẮT NGANG TRÌNH DUYỆT VÌ SẼ BỊ LEAK MEMORY DO TẮT TRÌNH DUYỆT NHƯNG KHÔNG TẮT DRIVER
        // VẬY SAU KHI TEST XONG TA CHỦ ĐỘNG TẮT TRÌNH DUYỆT TỬ TẾ, QUA HÀM  myBrowser.quit()
        // THÌ KHI ĐÓ DRIVER ĐC TẮT THEO
        
        // DELAY 1 TÍ RỒI TẮT, TỨC LÀ BẮT CPU ĐỢI VÀI GIÂY RỒI MỚI CHẠY LỆNH quit()
        Thread.sleep(5000);
        
        myBrowser.quit();
    }
}

// TEST CASE #1: - TEST GOOGLE SEARCH ENGINE WITH A KEYWORD "JACK ĐOM ĐÓM"
//      STEP/PROCEDURE:
//          1. OPEN A BROWSER, E.G. CHROME, EDGE
//          2. TYPE URL: HTTPS://GOOGLE.COM
//          3. TYPE "JACK ĐOM ĐÓM" INTO THE SEARCH TEXT
//          4. HIT ENTER TO INVOKE THE GOOGLE SEARCH FUNCTION

// EXPECTED RESULT:
//          A LIST OF WEBSITE WITH "JACK ĐOM ĐÓM" INCLUDED