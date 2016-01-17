package com.shashwat.arrayProblems;

/**
 * Question : Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 * @author Shashwat
 */
public class FindPairSum {
	private final static int MAX_ELEMENTS = 100;
	public static void main(String[] args) {
		int[] array = {1 ,5 , 4, 6, 45, 8, 6};
		int sum = 53;
		printPairs(array, sum);
	}

	private static void printPairs(int[] array, int sum) {
		boolean[] map = new boolean[MAX_ELEMENTS];
		
		for (int index = 0; index < array.length; index++) {
			int t = sum - array[index];
			if (t > 0 && map[t]) {
				System.out.println("Pair with sum : " + sum + " is ( "
						+ array[index] + ", " + t + " )");
			}
			map[array[index]] = true;
		}
	}
}
