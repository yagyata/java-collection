package com.bridgelabz.SetInterface;
import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println(convertToSortedList(set)); // Output: [1, 3, 5, 9]
    }

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>();
        for(int n : set) {
            list.add(n);
        }
        return list;
    }
}

