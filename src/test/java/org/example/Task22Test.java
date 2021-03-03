package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task22Test {

    @Test
    void case1() {
        int[] actual = Task22.solution(new int[] {4, 17, 50});
        int[] expected = {-1, -1};

        assertArrayEquals(actual, expected);
    }

    @Test
    void case2() {
        int[] actual = Task22.solution(new int[] {4, 30, 50});
        int[] expected = {12, 1};

        assertArrayEquals(actual, expected);
    }

}
