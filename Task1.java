// Task 1
import java.util.*;

public class Task1
{
    public static void helper(int cur_floor, List<int[]> order) {
            
        for(int[] a: order) a[2] = Math.abs(cur_floor - a[1]);
        Collections.sort(order, (a, b) -> a[2] - b[2]);
    }
    
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    List<int[]> order = new ArrayList<>();
	    
	    // Enter number of floors of a building.
	    int num_floors = s.nextInt();
	    
	    // Enter the current floor number.
	    int cur_floor = s.nextInt();
	    
	    // Enter number of people who are selecting floors.
	    int num_people = s.nextInt();
	    
	    /* Here we take the input of the person who request the floor number and save the difference between current floor and floor number requsted by person. */
	    for(int i = 1; i <= num_people; i++) {
	        int sel_floor = s.nextInt();
	        order.add(new int[]{i, sel_floor, Math.abs(sel_floor - cur_floor)});
	    }
	    
	    Collections.sort(order, (a, b) -> a[2] - b[2]);
	    
	    // Printing the sequence of the lift.
	    System.out.print("Elevator Sequence: ");
	    while(!order.isEmpty()) {
	        // Here we update the current floor after each iteration.
	        cur_floor = order.get(0)[1];
	        order.remove(0);
	        System.out.print(cur_floor + " ");
	        helper(cur_floor, order);
	    }
	}
}
