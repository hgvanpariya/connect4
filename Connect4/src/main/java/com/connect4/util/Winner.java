package com.connect4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connect4.util.thread.CheckColumn;
import com.connect4.util.thread.CheckDiaLeftRight;
import com.connect4.util.thread.CheckDiaRightLeft;
import com.connect4.util.thread.CheckRow;

public class Winner {

	Logger logger = LoggerFactory.getLogger(Winner.class);

	public boolean check(int[][] arr, int player, int row, int col) {
		CheckColumn checkColumn = new CheckColumn(arr, player, row, col);
		CheckRow checkRow = new CheckRow(arr, player, row, col);
		CheckDiaLeftRight checkDiaLeftRight = new CheckDiaLeftRight(arr, player, row, col);
		CheckDiaRightLeft checkDiaRightLeft = new CheckDiaRightLeft(arr, player, row, col);

		Thread checkColumnThread = new Thread(checkColumn);
		Thread checkRowThread = new Thread(checkRow);
		Thread checkDiaLeftRightThread = new Thread(checkDiaLeftRight);
		Thread checkDiaRightLeftThread = new Thread(checkDiaRightLeft);

		checkColumnThread.start();
		checkRowThread.start();
		checkDiaLeftRightThread.start();
		checkDiaRightLeftThread.start();

		try {
			checkColumnThread.join();
			checkRowThread.join();
			checkDiaLeftRightThread.join();
			checkDiaRightLeftThread.join();
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		
		return (checkColumn.isValid() || checkRow.isValid() || checkDiaLeftRight.isValid() || checkDiaRightLeft.isValid()); 

	}
}
