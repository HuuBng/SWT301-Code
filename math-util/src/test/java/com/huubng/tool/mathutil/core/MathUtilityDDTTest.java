package com.huubng.tool.mathutil.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilityDDTTest {

    // tách data ra khỏi hàm test
    // dựng mảng 2 chiều, input, expected
    // sau đó nhồi vào, fill vào câu lệnh so sánh!!!
    // data này sẽ là nguồn dữ liệu đề hàm so sánh gọi nhiều lần  như thế, do nhiều data
    // -> nguồn này là static để tìm kiếm nhanh chóng
    public static Object[][] initTestData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720}
        };
    }

    @ParameterizedTest
    @MethodSource("initTestData")
    public void testFactorialGivenRightArgumentRunsWell(int n, long expected) {
        assertEquals(expected, MathUtility.getFactorial(n));
    }

}