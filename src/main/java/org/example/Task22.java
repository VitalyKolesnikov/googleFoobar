package org.example;

public class Task22 {

    public static int[] solution(int[] pegs) {
        int num = -pegs[0];
        int sign = 1;

        for (int i = 1; i < pegs.length - 1; i++) {
            num += 2 * pegs[i] * sign;
            sign *= -1;
        }

        num += pegs[pegs.length - 1] * sign;
        num *= 2;

        int denom = (pegs.length % 2 == 0) ? 3 : 1;
        if (num % denom == 0) {
            num /= denom;
            denom = 1;
        }

        double radius = num * 1.0 / denom;
        for (int i = 0; i < pegs.length - 2; i++) {
            int gap = pegs[i + 1] - pegs[i];
            if (radius < 0 || radius > (gap - 1)) {
                return new int[]{-1, -1};
            }
            radius = gap - radius;
        }

        return new int[]{num, denom};
    }
}
