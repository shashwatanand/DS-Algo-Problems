package com.shashwat.codility;

public class Codility2Quest {
	public static void main(String[] args) {
		//int[] A = {1, 2, 3, 4, 5};
		//int[] A = {1, 1, 3};
		int[] A = {1, 1, 2, 3, 3, 4, 5, 5, 6, 7};
		System.out.println(solution(A, 2));
	}
	
	public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }

}
