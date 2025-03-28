package com.bridgelabz.listInterface;
import java.util.*;

public class RotateElements {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        Collections.rotate(elements, 2);
        System.out.println(Arrays.toString(elements.toArray()));
    }
}
