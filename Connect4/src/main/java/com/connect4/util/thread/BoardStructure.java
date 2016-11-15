package com.connect4.util.thread;

public class BoardStructure {
	public boolean valid = true;
	
	int[][] arr;
	int player = 0;

	int row = 0;
	int col = 0;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
