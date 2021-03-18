package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Task41.solution;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task41Test {

    @Test
    void case1() {
        int[][] actual = solution(2, 1);
        int[][] expected = {
                {0},
                {0}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case2() {
        int[][] actual = solution(4, 4);
        int[][] expected = {
                {0},
                {1},
                {2},
                {3}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case3() {
        int[][] actual = solution(3, 1);
        int[][] expected = {
                {0},
                {0},
                {0}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case4() {
        int[][] actual = solution(3, 2);
        int[][] expected = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case5() {
        int[][] actual = solution(3, 3);
        int[][] expected = {
                {0},
                {1},
                {2}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case6() {
        int[][] actual = solution(1, 1);
        int[][] expected = {{0}};

        assertArrayEquals(expected, actual);
    }

    @Test
    void case7() {
        int[][] actual = solution(2, 2);
        int[][] expected = {
                {0},
                {1}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void case8() {
        int[][] actual = solution(4, 3);
        int[][] expected = {
                {0, 1, 2         },
                {0,       3, 4   },
                {   1,    3,    5},
                {      2,    4, 5}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void case9() {
        int[][] actual = solution(5, 4);
        int[][] expected = {
                {0, 1, 2, 3                  },
                {0,          4, 5, 6         },
                {   1,       4,       7, 8   },
                {      2,       5,    7,    9},
                {         3,       6,    8, 9}
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void case10() {
        int[][] actual = solution(5, 3);
        int[][] expected = {
                {0, 1, 2, 3, 4, 5            },
                {0, 1, 2,          6, 7, 8   },
                {0,       3, 4,    6, 7,    9},
                {   1,    3,    5, 6,    8, 9},
                {      2,    4, 5,    7, 8, 9}
        };

        assertArrayEquals(expected, actual);
    }

}
