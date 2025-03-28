package com.bridgelabz.SetInterface;
import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println(symmetricSet(set1, set2));
    }
    public static Set<Integer> symmetricSet (Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> symmetrical = new HashSet<>(s1);
        symmetrical.addAll(s2);
        Set<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);

        symmetrical.removeAll(intersection);
        return symmetrical;


    }
}
