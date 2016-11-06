package com.connect4.util;

public class Trial {
	public static int[][] arr = new int[5][5];

	public static void main(String[] args) {

		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 0;
		arr[0][3] = 0;
		arr[0][4] = 0;
		arr[1][0] = 1;
		arr[1][1] = 0;
		arr[1][2] = 2;
		arr[1][3] = 0;
		arr[1][4] = 0;
		arr[2][0] = 1;
		arr[2][1] = 0;
		arr[2][2] = 0;
		arr[2][3] = 2;
		arr[2][4] = 0;
		arr[3][0] = 1;
		arr[3][1] = 0;
		arr[3][2] = 0;
		arr[3][3] = 0;
		arr[3][4] = 2;
		arr[4][0] = 0;
		arr[4][1] = 0;
		arr[4][2] = 0;
		arr[4][3] = 0;
		arr[4][4] = 0;
		// arr[5][0] = 0;
		// arr[5][1] = 0;
		// arr[5][2] = 0;
		// arr[5][3] = 0;
		// arr[5][4] = 0;
		Winner w = new Winner();
		boolean check = w.check(arr,1, 0, 0);
		System.out.println(check);
//		Trial t = new Trial();
//		t.check(arr,1, 0, 0);

	}

	

}



