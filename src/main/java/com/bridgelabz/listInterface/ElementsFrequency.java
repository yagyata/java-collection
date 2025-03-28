package com.bridgelabz.listInterface;

import java.util.*;

public class ElementsFrequency {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));
        Map<String,Integer> result = countFrequency(inputList);
        System.out.println(result);
    }

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0)+1);
        }
        return freqMap;
    }
}
