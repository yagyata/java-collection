package com.bridgelabz.SetInterface;
import java.util.*;

public class FindSubsets {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(checkSubset(s1, s2));

    }
    public static boolean checkSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }
}
