package org.example;


import java.util.ArrayList;
import java.util.List;

public class Task41 {

    public static int[][] solution(int num_buns, int num_required) {
        int keyCopies = num_buns - num_required + 1;

        ArrayList<ArrayList<Integer>> keyRings = new ArrayList<>(num_buns);
        for (int pos = 0; pos < num_buns; pos++) {
            keyRings.add(new ArrayList<>());
        }

        int key = 0;
        List<int[]> combinations = generate(num_buns, keyCopies);
        for (int[] keyRing : combinations) {
            for (int keyIndex : keyRing) {
                keyRings.get(keyIndex).add(key);
            }
            key++;
        }

        int[][] result = new int[num_buns][];
        for (int keyRingIndex = 0; keyRingIndex < keyRings.size(); keyRingIndex++) {
            ArrayList<Integer> keyRing = keyRings.get(keyRingIndex);
            result[keyRingIndex] = new int[keyRing.size()];
            for (int i = 0; i < keyRing.size(); i++) {
                result[keyRingIndex][i] = keyRing.get(i);
            }
        }

        return result;
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }
        return combinations;
    }

}
