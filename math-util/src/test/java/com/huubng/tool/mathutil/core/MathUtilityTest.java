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
}