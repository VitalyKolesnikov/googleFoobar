package org.example;

public class Task11 {
    public static String solution(String x) {
        char[] arr = x.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int code = arr[i];

            if (code >= 97 && code <= 109) {
                int shift = (109 - code) * 2 + 1;
                arr[i] = (char) (arr[i] + shift);
            }
            else if (code >= 110 && code <= 122) {
                int shift = (code - 97);
                arr[i] = (char) (122 - shift);
            }
        }
        return new String(arr);
    }
}
