package com.shashwat.arrayProblems;

/**
 * Question :  Find the sum of contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum. 
 * 
 * @author Shashwat
 *
 */
public class MaxSubArray {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Maximum contigous sum is " + getMaxSubArraySum(arr));
	}

	private static int getMaxSubArraySum(int[] arr) {
		int max = arr[0];
		int curr_max = arr[0];
		
		for (int index = 1; index < arr.length; index++) {
			curr_max = Math.max(arr[index], curr_max + arr[index]);
			max = Math.max(max, curr_max);
		}
		return max;
	}
}
