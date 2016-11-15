package com.connect4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect4.bean.GameBoard;

/**
 * This class will interact with the Database and fetch the details aboue
 * {@link GameBoard}
 * 
 * @author harikrushna
 * @see GameBoard
 *
 */
public interface GameBoardRepository extends MongoRepository<GameBoard, String> {

	/**
	 * Find the Goameboard by the ID of the gameboard
	 * 
	 * @param id
	 *            ID of the game.
	 * @return Object of the {@link GameBoard} which contains the id which is
	 *         provided.
	 */
	public GameBoard findById(String id);

	/**
	 * Find the {@link GameBoard} by the name og the Gameboard.
	 * 
	 * @param name
	 *            of the {@link GameBoard} which has to be found.
	 * @return Object of the {@link GameBoard} which contains the provided name.
	 */
	public GameBoard findByName(String name);

}