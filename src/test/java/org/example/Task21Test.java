package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task21Test {

    @Test
    void case1() {
        String actual = Task21.solution(3, 2);
        String expected = "9";

        assertEquals(actual, expected);
    }

    @Test
    void case2() {
        String actual = Task21.solution(5, 10);
        String expected = "96";

        assertEquals(actual, expected);
    }

    @Test
    void case3() {
        String actual = Task21.solution(1, 1);
        String expected = "1";

        assertEquals(actual, expected);
    }

    @Test
    void case4() {
        String actual = Task21.solution(5, 4);
        String expected = "33";

        assertEquals(actual, expected);
    }

    @Test
    void case5() {
        String actual = Task21.solution(6, 3);
        String expected = "34";

        assertEquals(actual, expected);
    }

}
