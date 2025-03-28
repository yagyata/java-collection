package com.bridgelabz.listInterface;

import java.util.*;

public class nthElementFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.print("Element found is: ");
        System.out.println(nthFromEnd(list,n));
    }
    public static <T> T nthFromEnd(LinkedList<T> list,int n) {
        int fast = n;
        int slow = 0;

        if(n > list.size()) {
            System.out.println("Invalid input");
        }

        while(fast < list.size()) {
            fast++;
            slow++;
        }
        return list.get(slow);
    }
}
