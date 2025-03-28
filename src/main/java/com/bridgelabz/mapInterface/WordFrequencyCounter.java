package com.bridgelabz.mapInterface;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String str = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = str.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> frequencies = countWordFrequencies(text);
        System.out.println("Word frequencies: " + frequencies);  // Output: {hello=2, world=1, java=1}
    }
}
