package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task31Test {

    @Test
    void case1() {
        int actual = Task31.solution(new int[]{1, 1, 1});
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    void case2() {
        int actual = Task31.solution(new int[]{1, 2, 3, 4, 5, 6});
        int expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    void case3() {
        int actual = Task31.solution(new int[]{1, 2, 3});
        int expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    void case4() {
        int actual = Task31.solution(new int[]{1, 2, 3, 7, 12, 20});
        int expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    void case5() {
        int actual = Task31.solution(new int[]{1, 2, 3, 7, 12, 20, 48, 80});
        int expected = 11;

        assertEquals(actual, expected);
    }

}
