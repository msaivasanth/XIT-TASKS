// Find the missing number in a given integer array of 1 to 100

import java.util.*;

public class Assignment4 {
    public static void helper(int[] arr) {
        int[] vis = new int[arr.length + 1];
        for(int i: arr) vis[i] = 1;

        for(int i = 1; i <= arr.length; i++) {
            if(vis[i] == 0) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        
        System.out.print("Enter elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        helper(arr);
        s.close();
    }
}