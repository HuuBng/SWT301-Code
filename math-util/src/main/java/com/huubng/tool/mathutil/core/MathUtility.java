package com.huubng.tool.mathutil.core;

public class MathUtility {

    // CLASS NÀY CHỨA CÁC HÀM STATIC LÀ NHỮNG HÀM TIỆN ÍCH DÙNG CHUNG CO MỌI NƠI

    // ĐÂY LÀ HÀM MÔ PHỎNG THƯ VIỆN TOÁN HỌC MATH, CỦA JDK
    // HÀM NÀY TÍNH N!
    // N! = 1.2.3...N
    // KO CÓ GIAI THỪA SỐ ÂM
    // 0! = 1
    // 20! VỪA ĐỦ KIỂU LONG, TỨC 21! VƯỢT KIỂU LONG
    public static long getFactorial(int n) {
        // ĐEM CODE CHÍNH RA SỬA GỌI LÀ REFACTOR/REFACTORING
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0 and 20");
        } // bạn đưa invalid data, tớ ném ra ngoại lệ, hàm ko đc chạy thành công, ko value trã về

        if (n == 0)
            return 1;

        // sống sót tới đây n = 1...19

        long result = 1; // thuật toán dồn con heo đất

        for (int i = 1; i <= n; i++)
            result *= i; // nhân dồn vào từng cháu i

        return result;
    }

}
