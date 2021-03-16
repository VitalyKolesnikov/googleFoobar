package org.example;

public class Task41 {

    public static void main(String[] args) {
        System.out.println(choose(5, 2));
    }

    // [5, 3]

    public static int[][] solution(int num_buns, int num_required) {

        int distinctKeysNum = choose(num_buns, num_required - 1); // 10
        int copiesPerKeyNum = num_buns - num_required + 1; // 3



        return null;
    }

    public static int choose(int n, int k) {
        int numerator = 1;
        int denominator = 1;

        for (int i = n; i >= (n - k + 1); i--) {
            numerator *= i;
        }

        for (int i = k; i >= 1; i--) {
            denominator *= i;
        }

        return (numerator / denominator);
    }

}
