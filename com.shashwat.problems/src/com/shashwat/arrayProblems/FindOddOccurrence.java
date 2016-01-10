package com.shashwat.arrayProblems;

/**
 * Question: Given an array of positive integers. All numbers occur even number of times except 
 * one number which occurs odd number of times. Find the number in O(n) time & constant space.
 */

public class FindOddOccurrence {
	public static void main(String[] args) {
		//int[] array = {1, 2, 3, 4, 5, 6, 3, 5 ,3, 2 ,2};
		int[] array = {1, 2, 3, 3, 3};//, 2 ,2};
		System.out.println("Old occurrence : " + findOddFindOddOccurrence(array));
	}
	
	static int findOddFindOddOccurrence(int[] input){
		int result = 0;
		for (int index = 0; index < input.length; index++) {
			result = result ^ input[index];
		}
		return result;
	}
}
