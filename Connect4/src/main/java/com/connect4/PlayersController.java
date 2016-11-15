package com.connect4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connect4.bean.GameBoard;
import com.connect4.bean.Player;
import com.connect4.repository.PlayerRepository;

import io.swagger.annotations.Api;

@Controller

@RequestMapping("/api/v1/connect4/")
@Api(value = "player", description = "Player controller")
public class PlayersController {

	@Autowired
	private PlayerRepository playerRepository;

	@RequestMapping(value = "/players/{name}", method = RequestMethod.GET)
	public @ResponseBody Player getPlayer(@PathVariable("name") String name) {
		Player findById = playerRepository.findByName(name);
		return findById;

	}

	@RequestMapping(value = "/players/", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody Player createPlayer(@RequestBody Player player) {
		Player findById = playerRepository.findByName(player.getName());
		if (findById == null) {
			playerRepository.save(player);
			return player;

		} else {
			return findById;
		}

	}

	@RequestMapping(value = "/players/{name}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Player> removePlayer(@PathVariable("name") String name) {
		Player playerFoundById = playerRepository.findByName(name);
		if (playerFoundById != null) {
			playerRepository.delete(playerFoundById);
			return new ResponseEntity<Player>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Player>(HttpStatus.BAD_REQUEST);

		}

	}
}
