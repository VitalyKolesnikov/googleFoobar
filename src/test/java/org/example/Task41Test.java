package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Task41.choose;
import static org.example.Task41.solution;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task41Test {

    @Test
    void choose_5_3_eq_10() {
        int actual = choose(5, 3);
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    void choose_4_4_eq_4() {
        int actual = choose(4, 4);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void choose_3_1_eq_3() {
        int actual = choose(3, 1);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    void case1() {
        int[][] actual = solution(2, 1);
        int[][] expected = {{0}, {0}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[][] actual = solution(5, 3);
        int[][] expected = {
                {0, 1, 2, 3, 4, 5},
                {0, 1, 2, 6, 7, 8},
                {0, 3, 4, 6, 7, 9},
                {1, 3, 5, 6, 8, 9},
                {2, 4, 5, 7, 8, 9}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int[][] actual = solution(4, 4);
        int[][] expected = {{0}, {1}, {2}, {3}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case4() {
        int[][] actual = solution(3, 1);
        int[][] expected = {{0}, {0}, {0}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case5() {
        int[][] actual = solution(3, 2);
        int[][] expected = {{0, 1}, {0, 2}, {1, 2}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case6() {
        int[][] actual = solution(3, 3);
        int[][] expected = {{0}, {1}, {2}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case7() {
        int[][] actual = solution(1, 1);
        int[][] expected = {{0}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case8() {
        int[][] actual = solution(2, 2);
        int[][] expected = {{0}, {1}};

        assertArrayEquals(expected, actual);
    }

}
