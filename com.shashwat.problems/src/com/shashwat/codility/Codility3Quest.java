package com.shashwat.codility;





public class Codility3Quest {
	public static void main(String[] args) {
		String S = "011100";
		System.out.println(solution(S));
	}
	
	public static int solution(String S) {
        // write your code in Java SE 8
		int input = Integer.parseInt(S, 2);
		int count = 0;
		//System.out.println(input);
		while (input != 0) {
			if (input % 2 == 0) {
				input = input / 2;
			} else {
				input--;
			}
			count++;
		}
		
		return count;
    }
}
