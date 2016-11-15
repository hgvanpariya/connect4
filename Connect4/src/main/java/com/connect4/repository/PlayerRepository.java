package com.connect4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect4.bean.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

//	public Player findById(String id);

	public Player findByName(String name);


}