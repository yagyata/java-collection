package com.bridgelabz.SetInterface;
import java.util.*;

public class EqualSets {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,2,1));
        System.out.println(checkEquality(s1,s2));
    }
    public static boolean checkEquality(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size() != set2.size()){
            return false;
        }
        for(int num: set1) {
            if(!set2.contains(num)) {
                return false;
            }
        }
        return true;
    }
}
