// Write a function that merges two unsorted lists into a new sorted list

import java.util.*;

public class Assignment1
{
	public static List<Integer> helper(int[] arr1, int[] arr2) {
		List<Integer> res = new ArrayList<>();
		
		for(int i: arr1) res.add(i);
		for(int i: arr2) res.add(i);

		Collections.sort(res);

		return res;
	}
  public static void main (String[]args)
  {
	Scanner s = new Scanner(System.in);
	int n1 = s.nextInt();
	int[] arr1 = new int[n1];
	int n2 = s.nextInt();
	int[] arr2 = new int[n2];
	
	
	for(int i = 0; i < n1; i++) {
	    arr1[i] = s.nextInt();
	    // res.add(arr1[i]);
	}
	for(int i = 0; i < n2; i++) {
	    arr2[i] = s.nextInt();
	    // res.add(arr2[i]);
	}
	
	
	System.out.println(helper(arr1, arr2));
	
  }
}
