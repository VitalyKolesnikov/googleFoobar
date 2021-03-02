package level2.task1;

public class Solution {
    public static String solution(long x, long y) {

        long counter = 0;
        long sum = 0;

        for (long i = 1; i <= x; i++) {
            sum += ++counter;
        }

        for (long i = 1; i < y; i++) {
            sum += counter++;
        }

        return Long.toString(sum);
    }
}
