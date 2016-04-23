package com.shashwat.codility;
/*
 * A non-empty zero-indexed array A of bits (1s and/or 0s) 
 * is given. The maximal binary ones span of A is the length of 
 * the longest sequence of consecutive 1s. For example, for A such that: 
 A[0] = 0
 A[1] = 1
 A[2] = 1
 A[3] = 1
 A[4] = 0
 A[5] = 1
 A[6] = 1
 A[7] = 1
 A[8] = 0
 A[9] = 1
 the maximal binary ones span equals 3. There are two sequences of 
 consecutive 1s of such a length: A[1..3] and A[5..7].
 */

public class Codility5Quest {
	public static void main(String[] args) {
		int[] A = {0, 1, 1, 1, 0, 1, 1, 1, 1, 0 ,1};
		//int[] A = { 0, 0 };
		System.out.println(solution(A));
	}

	static int solution(int[] A) {
		int n = A.length;
		int i = n - 1;
		int result = -1;
		int k = 0, maximal = 0;
		while (i > 0) {
			if (A[i] == 1) {
				k = k + 1;
				if (k >= maximal) {
					maximal = k;
					result = i;
				}
			} else
				k = 0;
			i = i - 1;
		}
		if (A[i] == 1 && k + 1 >= maximal)
			result = 0;
		return result;
	}
}
