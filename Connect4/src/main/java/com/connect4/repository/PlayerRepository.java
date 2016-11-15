package com.connect4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.connect4.bean.Player;

/**
 * This class is designed to fetch the details about the Player and it will
 * interact with the DB ( {@link MongoRepository}. )
 * 
 * @author harikrushna
 *
 */
public interface PlayerRepository extends MongoRepository<Player, String> {

	/**
	 * 
	 * Find the Player with the name of the {@link Player}
	 * 
	 * @param name
	 *            name of the {@link Player} which has to be found.
	 * @return Object of the {@link Player} with the given name.
	 */
	public Player findByName(String name);

}