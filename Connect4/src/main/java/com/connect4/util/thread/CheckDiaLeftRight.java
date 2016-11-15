package com.connect4.util.thread;

/**
 * This class will check the diagram from left to the Right
 * 
 * @author harikrushna
 *
 */
public class CheckDiaLeftRight extends BoardStructure implements Runnable {

	public CheckDiaLeftRight(int[][] arr, int player, int row, int col) {
		super();
		this.arr = arr;
		this.player = player;
		this.row = row;
		this.col = col;
	}

	@Override
	public void run() {

		valid = true;

		int count = 0;
		while (count < 4 && row < arr.length && col < arr[row].length) {
			if (arr[row++][col++] == player) {
				count++;
			} else {
				valid = false;
				break;
			}
		}

	}

}
