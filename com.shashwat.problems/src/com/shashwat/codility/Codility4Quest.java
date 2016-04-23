package com.shashwat.codility;

/*
 * check if a list can be sorted by performing at most one swap operation, and I want to return true if it does. Otherwise, I want to return false.
 * For example, the input
 * A = [1,2,3,4,5]
 * should result in true because it is already sorted.
 * A = [1,2,5,4,3]

should result in true because with one swap, involving 5 and 3, the list is sorted.

A = [1,2,5,3,4]

should result in false because it requires more than one swap to sort.

 */

public class Codility4Quest {
	public static void main(String[] args) {
		//int[] A = {1, 5, 3, 3, 7};
		int[] A = {1, 3, 5, 3, 4};
		System.out.println(solution(A));
		//System.out.println(sort(A));
	}

	public static boolean solution(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] <= A[i]){
				continue;
			}
			int t1 = A[i - 1];
			int t1Index = i - 1;
			
			while (t1Index - 1 >= 0 && A[t1Index - 1] == t1) {
				--t1Index;
			}
			i++;
			for (; i < A.length; ++i) {
				if (A[i] > t1) {
					break;
				}
			}
			int t2Index = i - 1;
			int t2 = A[t2Index];
			A[t1Index] = t2;
			A[t2Index] = t1;

			/*for (i = (t2 == 0 ? 1 : t2); i < A.length; ++i) {
				if (A[i - 1] > A[i]) {
					return false;
				}
			}*/
//			for (i = 1; i < A.length; ++i) {
//				if (A[i - 1] > A[i]) {
//					return false;
//				}
//			}
			System.out.println(isArraySorted(A));
			return isArraySorted(A);
		}
		return true;
	}

	private static boolean isArraySorted(int[] A) {
		for(int i = 0; i < A.length - 1; ++i) {
	          if(A[i] > A[i+1])
	              return false;
	       }

	       return true;
	}
}
