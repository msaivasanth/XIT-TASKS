/*Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),

design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0. */

import java.util.*;

public class Task5 {
    public static void helper(int[] prices, int n) {
        int price = prices[0];
        int max_profit = 0;

        for(int i = 1; i < n; i++) {
            max_profit = Math.max(max_profit, (prices[i] - price));
            price = Math.min(price, prices[i]);
        }

        System.out.println(max_profit);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] prices = new int[n];
        
        for(int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        helper(prices, n);
    }
}
