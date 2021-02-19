import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
	
	public Test() {}
	
	private static Random rnd = new Random();
	private static int generateNumber(int max) {
		int num = rnd.nextInt(max);
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("This Java program will find the longest increasing subsequence from a list of random numbers!");
		
		int len = Integer.MAX_VALUE;
		while(len > 1) {
			System.out.print("\nPlease enter an integer > 1 to determine the list's length: ");
			len = sc.nextInt();
			System.out.println("");
			if(len <= 0) break;
			
			System.out.println("Generating a list of random numbers from 0 to 100...");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < len; i++) {
				list.add(generateNumber(100));
			}
			System.out.println(list.toString());
			
			LongestIncreasingSubsequence lisSolver = new LongestIncreasingSubsequence(list);
			ArrayList<Integer> lis = lisSolver.solve();
			System.out.println("\nThe longest increasing subsequence is: ");
			System.out.println(lis.toString());
			System.out.println("with a length of " + lis.size() + "!");
		}

		System.out.println("Thank you for testing this program!");
		sc.close();
	}

}
