package com.huubng.tool.mathutil.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityTest {

    @Test // @/Test mang ý nghĩa biến hàm ở dưới thành hàm main() thì mới chạy lệnh test khi run app
    // TEST CASE #1: VERIFY GETFACTORIAL() WITH N = 0
    void testFactorialGivenRightArgument0RunsWell() {
        int n = 0;
        long expected = 1; // hy vong n = 0, tức là 0! sẽ có giá trị là 1
        long actual = MathUtility.getFactorial(n);
        assertEquals(expected,actual); // so sánh xem thực tế có như kì vọng ko ??
        // nếu ko thì ra màu đò,
        // đúng ra xanh
    }

    // TEST CASE #2: VERIFY GETFACTORIAL() WITH N = 1
    @Test
    void testFactorialGivenRightArgument1RunsWell() {
        int n = 1;
        long expected = 1; // hy vong n = 0, tức là 0! sẽ có giá trị là 1
        long actual = MathUtility.getFactorial(n);
        assertEquals(expected,actual); // so sánh xem thực tế có như kì vọng ko ??
        // nếu ko thì ra màu đò,
        // đúng ra xanh
    }

    // TEST CASE #3: VERIFY GETFACTORIAL() WITH N = 1
    @Test
    void testFactorialGivenRightArgumentRunsWell() {
        assertEquals(2,MathUtility.getFactorial(2));
        assertEquals(6,MathUtility.getFactorial(3));
        assertEquals(24,MathUtility.getFactorial(4));
        assertEquals(120,MathUtility.getFactorial(5));
    }

    // TEST CASE #4 (BẮT NGOẠI LỆ
    // VERIFY getFactorial() with n < 0, e.g. n = -5 to throw an exception
    // Steps:
    // 1. Given an invalid number n = -5
    // 2. Call/invoke the function getFactorial(-5)
    // Expected result:
    // an IllegalArgumentException will be thrown
    // Nếu đưa -5 cà chớn, hy vọng sẽ nhìn thấy ngoại lệ
    @Test
    public void testFactorialGivenWrongArgumentMinus5ThrowException() {
        // MathUtility.getFactorial(-5);
        // Ta phải kiểm soát, ta phải đo xem ngoại lệ đã đến chưa nếu là -5 đưa vào
        assertThrows(IllegalArgumentException.class, () -> MathUtility.getFactorial(-5));
        // So sánh, đo xem, nhắm xem, ngoại lệ đã xuất hiện chưa nếu gọi -5!
        // Cú pháp biểu thức lambda
    }
}