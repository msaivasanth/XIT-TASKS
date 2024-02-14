// TASK - 2
import java.util.*;

public class Task2
{
    public static List<List<Integer>> ds;
    public static int max = Integer.MIN_VALUE;
    public static Map<Integer, Integer> result;
    public static void helper(int ind, int[][] bank, int amount, List<Integer> lis) {
        if(ind == bank.length) {
            if(amount == 0) {
                HashMap<Integer, Integer> mp = new HashMap<>();
                for(int i: lis) mp.put(i, mp.getOrDefault(i, 0) + 1);
                if(mp.size() > max) {
                    result = mp;
                    max = mp.size();
                }
                ds.add(new ArrayList<>(lis));
                return ;
            }
            return ;
        }
    
        
        if(amount - bank[ind][0] >= 0 && bank[ind][1] > 0) {
            lis.add(bank[ind][0]);
            bank[ind][1] -= 1;
            helper(ind, bank, amount - bank[ind][0], lis);
            bank[ind][1] += 1;
            lis.remove(lis.size() - 1);
        }
        
        helper(ind + 1, bank, amount, lis);
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ds = new ArrayList<>();
		result = new HashMap<>();
		int[][] bank = new int[4][2];
		bank[0][0] = 2000; bank[1][0] = 500; bank[2][0] = 200; bank[3][0] = 100;
		
		System.out.println("Enter number of 2000 notes : ");
		bank[0][1] = s.nextInt();
		System.out.println("Enter number of 500 notes : ");
		bank[1][1] = s.nextInt();
		System.out.println("Enter number of 200 notes : ");
		bank[2][1] = s.nextInt();
		System.out.println("Enter number of 100 notes : ");
		bank[3][1] = s.nextInt();
		
		System.out.println("Enter the amount to be deducted from bank: ");
		int amount = s.nextInt();
		
		helper(0, bank, amount, new ArrayList<>());
		
// 		System.out.println(ds);
        
		System.out.println(result);
		for(int i = 0; i < 4; i++) {
		    bank[i][1] -= result.getOrDefault(bank[i][0], 0);
		}
		System.out.println("Notes present in ATM: ");
		for(int[] a: bank) {
		    System.out.println(a[0] + " = " + a[1]);
		}
	
	}
}