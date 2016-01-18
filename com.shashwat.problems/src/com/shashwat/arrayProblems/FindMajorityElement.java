package com.shashwat.arrayProblems;

/**
 * Question : A majority element in an array A[] of size n 
 * is an element that appears more than n/2 times
 * 
 * @author Shashwat
 *
 */
public class FindMajorityElement {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4 ,4, 4, 4, 4, 5};
		displayMajorityElement(arr);
	}

	private static void displayMajorityElement(int[] arr) {
		int candidate = findCandidate(arr);
		if (isMajorityElement(candidate, arr)) {
			System.out.println(candidate);
		} else {
			System.out.println("No majority element found");
		}
	}

	private static boolean isMajorityElement(int candidate, int[] arr) {
		int count = 0;
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] ==  candidate) {
				count++;
			}
		}
		if (count > arr.length/2) {
			return true;
		}
		return false;
	}

	private static int findCandidate(int[] arr) {
		int cand_index = 0, count = 1;
		for (int index = 1; index < arr.length; index++) {
			if (arr[cand_index] == arr[index]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				arr[cand_index] = index;
			}
		}
		return arr[cand_index];
	}
}
