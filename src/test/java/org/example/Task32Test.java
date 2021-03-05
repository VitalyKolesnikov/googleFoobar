package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Task32.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task32Test {

    @Test
    void gcd_4_2_eq_2() {
        int actual = Fraction.gcd(4, 2);
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void gcd_3_7_eq_1() {
        int actual = Fraction.gcd(3, 7);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void gcd_9_18_eq_9() {
        int actual = Fraction.gcd(9, 18);
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void gcd_10_15_eq_5() {
        int actual = Fraction.gcd(10, 15);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void simplify_2_4_eq_1_2() {
        Fraction actual = new Fraction(2, 4);
        actual.simplify();
        Fraction expected = new Fraction(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void simplify_3_9_eq_1_3() {
        Fraction actual = new Fraction(3, 9);
        actual.simplify();
        Fraction expected = new Fraction(1, 3);

        assertEquals(expected, actual);
    }

    @Test
    void simplify_4_16_eq_1_4() {
        Fraction actual = new Fraction(4, 16);
        actual.simplify();
        Fraction expected = new Fraction(1, 4);

        assertEquals(expected, actual);
    }

    @Test
    void simplify_2_5_eq_2_5() {
        Fraction actual = new Fraction(2, 5);
        actual.simplify();
        Fraction expected = new Fraction(2, 5);

        assertEquals(expected, actual);
    }

    @Test
    void simplify_minus_3_9_eq_minus_1_3() {
        Fraction actual = new Fraction(3, 9, -1);
        actual.simplify();
        Fraction expected = new Fraction(1, 3, -1);

        assertEquals(expected, actual);
    }

    @Test
    void add_2_3_plus_5_7_eq_29_21() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(5, 7);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(29, 21);

        assertEquals(expected, actual);
    }

    @Test
    void add_1_2_plus_3_4_eq_5_4() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(5, 4);

        assertEquals(expected, actual);
    }

    @Test
    void add_1_8_plus_3_8_eq_1_2() {
        Fraction f1 = new Fraction(1, 8);
        Fraction f2 = new Fraction(3, 8);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void add_2_3_plus_minus_5_7_eq_minus_1_21() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(5, 7, -1);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(1, 21, -1);

        assertEquals(expected, actual);
    }

    @Test
    void add_3_4_plus_minus_1_4_eq_1_2() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 4, -1);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    void add_minus_1_5_plus_minus_2_5_eq_minus_3_5() {
        Fraction f1 = new Fraction(1, 5, -1);
        Fraction f2 = new Fraction(2, 5, -1);
        Fraction actual = Fraction.add(f1, f2);
        Fraction expected = new Fraction(3, 5, -1);

        assertEquals(expected, actual);
    }

    @Test
    void getNumOfTerminalRows_4() {
        Matrix matrix = new Matrix(new int[][]
                {
                        {0, 1, 0, 0, 0, 1},
                        {4, 0, 0, 3, 2, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                });
        int actual = matrix.getNumOfTerminalRows();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void getNumOfTerminalRows_6() {
        Matrix matrix = new Matrix(new int[][]
                {
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                });
        int actual = matrix.getNumOfTerminalRows();
        int expected = 6;

        assertEquals(expected, actual);
    }

    @Test
    void getNumOfTerminalRows_0() {
        Matrix matrix = new Matrix(new int[][]
                {
                        {0, 1, 0, 0, 0, 1},
                        {4, 0, 0, 3, 2, 0},
                        {4, 0, 0, 3, 2, 0}
                });
        int actual = matrix.getNumOfTerminalRows();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void getRowDenom_9() {
        int[] row = new int[]{0, 1, 0, 5, 0, 3};
        int actual = Matrix.getRowSum(row);
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void getRowDenom_0() {
        int[] row = new int[]{0, 0, 0, 0, 0, 0};
        int actual = Matrix.getRowSum(row);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void subtract_2_3_minus_5_7_eq_minus_1_21() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(5, 7);
        Fraction actual = Fraction.subtract(f1, f2);
        Fraction expected = new Fraction(1, 21, -1);

        assertEquals(expected, actual);
    }

    @Test
    void subtract_3_4_minus_minus_1_4_eq_1() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 4, -1);
        Fraction actual = Fraction.subtract(f1, f2);

        assertEquals(ONE, actual);
    }

    @Test
    void subtract_7_8_minus_3_7_eq_25_56() {
        Fraction f1 = new Fraction(7, 8);
        Fraction f2 = new Fraction(3, 7);
        Fraction actual = Fraction.subtract(f1, f2);
        Fraction expected = new Fraction(25, 56);

        assertEquals(expected, actual);
    }

    @Test
    void multiply_2_3_and_5_7_eq_10_21() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(5, 7);
        Fraction actual = Fraction.multiply(f1, f2);
        Fraction expected = new Fraction(10, 21);

        assertEquals(expected, actual);
    }

    @Test
    void multiply_1_2_and_minus_3_4_eq_minus_3_8() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4, -1);
        Fraction actual = Fraction.multiply(f1, f2);
        Fraction expected = new Fraction(3, 8, -1);

        assertEquals(expected, actual);
    }

    @Test
    void multiply_minus_1_8_and_minus_3_8_eq_3_64() {
        Fraction f1 = new Fraction(1, 8, -1);
        Fraction f2 = new Fraction(3, 8, -1);
        Fraction actual = Fraction.multiply(f1, f2);
        Fraction expected = new Fraction(3, 64);

        assertEquals(expected, actual);
    }

    @Test
    void lcm_0_and_3_14_and_1_7_and_9_14_eq_14() {
        Fraction f1 = new Fraction(0, 1);
        Fraction f2 = new Fraction(3, 14);
        Fraction f3 = new Fraction(1, 7);
        Fraction f4 = new Fraction(9, 14);
        int actual = Fraction.lcm(f1, f2, f3, f4);
        int expected = 14;

        assertEquals(expected, actual);
    }

    @Test
    void case1() {
        int[][] matrix = new int[][]
                {
                        {0, 1, 0, 0, 0, 1},
                        {4, 0, 0, 3, 2, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {0, 3, 2, 9, 14};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[][] matrix = new int[][]
                {
                        {0, 2, 1, 0, 0},
                        {0, 0, 0, 3, 4},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {7, 6, 8, 21};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int[][] matrix = new int[][]
                {
                        {1, 2, 3, 0, 0, 0},
                        {4, 5, 6, 0, 0, 0},
                        {7, 8, 9, 1, 0, 0},
                        {0, 0, 0, 0, 1, 2},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 2, 3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case4() {
        int[][] matrix = new int[][]
                {
                        {0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case5() {
        int[][] matrix = new int[][]
                {
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 0, 1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case6() {
        int[][] matrix = new int[][]
                {
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 0, 0, 0, 0, 1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case7() {
        int[][] matrix = new int[][]
                {
                        {0, 0, 12, 0, 15, 0, 0, 0, 1, 8},
                        {0, 0, 60, 0, 0, 7, 13, 0, 0, 0},
                        {0, 15, 0, 8, 7, 0, 0, 1, 9, 0},
                        {23, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {37, 35, 0, 0, 0, 0, 3, 21, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 2, 3, 4, 5, 15};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case8() {
        int[][] matrix = new int[][]
                {
                        { 0,  7,   0,  17,   0,  1,   0,  5,   0,  2},
                        { 0,  0,  29,   0,  28,  0,   3,  0,  16,  0},
                        { 0,  3,   0,   0,   0,  1,   0,  0,   0,  0},
                        {48,  0,   3,   0,   0,  0,  17,  0,   0,  0},
                        { 0,  6,   0,   0,   0,  1,   0,  0,   0,  0},
                        { 0,  0,   0,   0,   0,  0,   0,  0,   0,  0},
                        { 0,  0,   0,   0,   0,  0,   0,  0,   0,  0},
                        { 0,  0,   0,   0,   0,  0,   0,  0,   0,  0},
                        { 0,  0,   0,   0,   0,  0,   0,  0,   0,  0},
                        { 0,  0,   0,   0,   0,  0,   0,  0,   0,  0}
                };
        int[] actual = solution(matrix);
        int[] expected = {4, 5, 5, 4, 2, 20};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case9() {
        int[][] matrix = new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 1, 1, 1, 1, 5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case10() {
        int[][] matrix = new int[][]
                {
                        {1, 1, 1, 0, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {2, 1, 1, 1, 1, 6};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case11() {
        int[][] matrix = new int[][]
                {
                        {0, 86, 61, 189, 0, 18, 12, 33, 66, 39},
                        {0, 0, 2, 0, 0, 1, 0, 0, 0, 0},
                        {15, 187, 0, 0, 18, 23, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {6, 44, 4, 11, 22, 13, 100};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case12() {
        int[][] matrix = new int[][]
                {
                        {0, 0, 0, 0, 3, 5, 0, 0, 0, 2},
                        {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 4, 4, 0, 0, 0, 1, 1},
                        {13, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                        {0, 1, 8, 7, 0, 0, 0, 1, 3, 0},
                        {1, 7, 0, 0, 0, 0, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        int[] actual = solution(matrix);
        int[] expected = {1, 1, 1, 2, 5};

        assertArrayEquals(expected, actual);
    }

}
