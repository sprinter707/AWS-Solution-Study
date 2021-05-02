package util;

import java.util.ArrayList;
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
    public static void print(String[] q) {
        Arrays.stream(q).forEach(i -> System.out.print("[" + i + "]"));
    }
    public static void print(ArrayList<String> list) {
        list.stream().forEach(i->System.out.println("[" + i + "]"));
    }

    public static void print(int ans) {
        System.out.println("[" + ans + "]");
    }
}
