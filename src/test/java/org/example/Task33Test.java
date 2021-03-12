package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Task33.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task33Test {

    @Test
    void case1() {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {1, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        int[][] matrix = new int[][]{
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 7;

        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int actual = solution(matrix);
        int expected = 11;

        assertEquals(expected, actual);
    }

    @Test
    void case4() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int actual = solution(matrix);
        int expected = 24;

        assertEquals(expected, actual);
    }

    @Test
    void case5() {
        int[][] matrix = new int[][]{
                {0, 1, 0},
                {0, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void case6() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int actual = solution(matrix);
        int expected = 11;

        assertEquals(expected, actual);
    }

    @Test
    void case7() {
        int[][] matrix = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        };
        int actual = solution(matrix);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void case8() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int actual = solution(matrix);
        int expected = 24;

        assertEquals(expected, actual);
    }

    @Test
    void case9() {
        int[][] matrix = new int[][]{
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    void case10() {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    void case11() {
        int[][] matrix = new int[][]{
                {0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0}
        };
        int actual = solution(matrix);
        int expected = 10;

        assertEquals(expected, actual);
    }

}
