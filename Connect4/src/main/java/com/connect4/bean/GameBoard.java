package com.connect4.bean;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.connect4.util.Winner;

/**
 * This class is designed to store the Game board details.
 * 
 * @author Harikrushna
 *
 */
@Component
public class GameBoard {

	@Id
	private String id;

	private int row;

	private int col;

	private int[][] boardStatus = null;
	private int[] allColStatus = null;
	private String[] allPlayers = null;

	private String name;

	private int winner = -1;

	public GameBoard() {
		super();
		if (boardStatus == null) {
			boardStatus = new int[row][col];
			allColStatus = new int[col];
		}
	}

	public GameBoard(int row, int col, String[] allPlayers) {
		super();
		this.row = row;
		this.col = col;
		boardStatus = new int[row][col];
		this.allPlayers = allPlayers;
	}

	public boolean moveForPlayer(int pleayerIndex, int row) {
		pleayerIndex++;
		int toprow = allColStatus[row];
		boolean check = false;
		if (boardStatus.length > toprow) {

			boardStatus[toprow][row] = pleayerIndex;
			allColStatus[row] = toprow + 1;

			Winner w = new Winner();
			check = w.check(boardStatus, pleayerIndex, toprow, row);
			System.out.println(check);
		}
		return check;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int[][] getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(int[][] boardStatus) {
		this.boardStatus = boardStatus;
	}

	public int[] getAllColStatus() {
		return allColStatus;
	}

	public void setAllColStatus(int[] allColStatus) {
		this.allColStatus = allColStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String[] getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(String[] allPlayers) {
		this.allPlayers = allPlayers;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

}
