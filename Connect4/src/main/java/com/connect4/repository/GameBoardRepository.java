package com.connect4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect4.bean.GameBoard;

public interface GameBoardRepository extends MongoRepository<GameBoard, String> {

	public GameBoard findById(String id);
	
	public GameBoard findByName(String name);

}