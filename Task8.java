/*Given an integer n, break into  the sum of k positive integers, and return the maximum product of those integers.

Input:
Integer n

Desired Output:
Maximum product of numbers whose sum is n.

Example 1:
n=5;

5 can be written as sum of following numbers.
Possible Sums:
1.            1+1+1+1+1,
2.            1+4,
3.            1+1+3,
4.            1+1+1+2,
5.            2+3,
6.            1+2+2.....etc

Product of these integers:
1.            1*1*1*1*1=1,
2.            1*4=4,
3.            1*1*3=3,
4.            1*1*1*2=2
5.            2*3=6,
6.            1*2*2=4.....etc

Output returned should be maximum product which in the above case is 6.

 
Example 2:
n=10;

Desired Output : 36

Integers : 3,3,4 or 3,3,2,2
*/

import java.util.*;
public class Task8 {
    public static int helper(int n, int i) {
        if(n == 0) {
            return 1;
        }
        if(i > n) return n;

        int proPick = 1, proNotPick = 1;
        if(n >= i) {
            proPick = (i * helper(n - i, i));
        }
        if(i + 1 < n)proNotPick = helper(n, i + 1);
        
        return Math.max(proPick, proNotPick);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = s.nextInt();

        System.out.println("Maximum product of numbers whose sum is " + n +": " + helper(n, 1));
    }
}