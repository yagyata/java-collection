package com.bridgelabz.listInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("Reversed Array: ");
        listReverse(arr);

        System.out.println();

        System.out.print("Reversed Linked List: ");
        List<Integer> ll = new LinkedList<>(Arrays.asList(5, 6, 7, 8, 9));
        listReverse(ll);
    }
    public static void listReverse(List<Integer> arr) {
        for(int i=arr.size() - 1; i>=0; i--) {
            System.out.print(arr.get(i) + " ");
        }
    }

}
