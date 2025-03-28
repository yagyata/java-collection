package com.bridgelabz.SetInterface;
import java.util.*;

public class SetsUnionAndIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));
        System.out.println("Union: " + union(set1,set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }

    public static Set<Integer> union(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }
}
