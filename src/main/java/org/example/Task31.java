package org.example;

public class Task31 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 7, 12, 20, 48, 80}));
    }

    public static int solution(int[] l) {
        int result = 0;
        for (int i = 0; i <= l.length - 2; i++) {
            for (int j = i + 1; j < l.length - 1; j++) {
                for (int k = j + 1; k < l.length; k++) {
                    if (isDivider(l[k], l[j]) && isDivider(l[j], l[i])) result++;
                }
            }
        }
        return result;
    }

    public static boolean isDivider(int num, int divider) {
        return num % divider == 0;
    }

}
