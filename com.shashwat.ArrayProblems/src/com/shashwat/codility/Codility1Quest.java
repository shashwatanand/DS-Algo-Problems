package com.shashwat.codility;


/**
 * An integer X and a non-empty zero-indexed array A consisting of N integers are given. 
 * We are interested in which elements of A are equal to X and which are different from X. 
 * The goal is to split array A into two parts, such that the number of elements equal to X in the first part 
 * is the same as the number of elements different from X in the other part.
 * More formally, we are looking for an index K such that: 0 ≤ K < N and the number of 
 * elements equal to X in A[0..K−1] is the same as the number of elements different 
 * from X in A[K..N−1]. For K = 0, A[0..K−1] does not contain any elements.
 */

public class Codility1Quest {
	public static void main(String[] args) {
		int[] A = {5, 5, 1, 7, 2, 3, 5};
		int X = 5;
		System.out.println(solution(X, A));
	}

	public static int solution(int X, int[] A) {
		int high = A.length - 1;
		int low = 0;
		int rCount = 0;
		int lCount = 0;
		
		
		if (A[high] != X) rCount ++;
		if (A[low] == X) lCount++;
		
		while (low != high) {
			if (lCount > rCount) {
				high--;
				if (A[high] != X) rCount++;
			} else {
				low++;
				if (A[low] ==  X) lCount++;
			}
		}
		
		if (high > 0) {
			if (high == A.length - 1) {
				if (lCount == 0) {
					return -1;
				} else {
					return high;
				}
			} else {
				return high;
			}
		} else {
			return -1;
		}
	}
}
