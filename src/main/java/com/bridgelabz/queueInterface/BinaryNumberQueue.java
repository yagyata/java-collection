package com.bridgelabz.queueInterface;
import java.util.*;

public class BinaryNumberQueue {
    public static void main(String[] args) {
        int n = 5;
        System.out.print("Binary Numbers upto " + n + " are: ");
        System.out.println(generateBinaryNumbers(n)); // Output: [1, 10, 11, 100, 101]
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.remove();
            result.add(binary);

            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        return result;
    }
}

