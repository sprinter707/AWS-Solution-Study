package util;

import java.util.Arrays;
import java.util.Queue;

public class Util {
    public static void print(Queue<Integer> q) {
        q.stream().forEach(i -> System.out.print("[" + i + "]"));
        System.out.println();
    }

    public static void print(int[] q) {
        Arrays.stream(q).forEach(i -> System.out.print("[" + i + "]"));
    }

    public static void print(int ans) {
        System.out.println("[" + ans + "]");
    }
}
