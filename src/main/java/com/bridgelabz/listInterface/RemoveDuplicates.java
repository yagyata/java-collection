package com.bridgelabz.listInterface;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,1,2,2,3,4));
        System.out.println(duplicatesRemove(list));
    }
    public static List<Integer> duplicatesRemove(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int num : list) {
            if (seen.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
