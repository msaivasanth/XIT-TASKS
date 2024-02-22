// Write a function to remove duplicates from an array

import java.util.*;

public class Assignment3 {
    public static void helper(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for(int i: arr) {
            if(!res.contains(i)) {
                res.add(i);
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        helper(arr);
    }
}
