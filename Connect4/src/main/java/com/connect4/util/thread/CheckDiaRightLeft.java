package com.connect4.util.thread;

/**
 * 
 * This class will check the the Diagonally from right to left for the winner.
 * 
 * @author harikrushna
 *
 */
public class CheckDiaRightLeft extends BoardStructure implements Runnable {

	public CheckDiaRightLeft(int[][] arr, int player, int row, int col) {
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

		while (count < 4 && row < arr.length && col < arr[row].length && col > 0 && row > 0) {
			if (arr[row++][col--] == player) {
				count++;
			} else {
				valid = false;
				break;
			}
		}

		if (count != 3) {
			this.valid = false;
		}

	}

}
