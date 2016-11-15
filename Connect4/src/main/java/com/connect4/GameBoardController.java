package com.connect4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
import com.connect4.repository.GameBoardRepository;
import com.connect4.repository.PlayerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@Controller
@RequestMapping("/api/v1/connect4/")
@Api(value = "gameboard", description = "Gameboard controller")
@PropertySource({"classpath:application.properties"})
public class GameBoardController {

	@Autowired
	private GameBoardRepository gameBoardRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@RequestMapping(value = "/gameboards/{id}", method = RequestMethod.GET)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "Name of the gameboard", required = true, dataType = "String") })
	public @ResponseBody GameBoard getGameboardStatus(@PathVariable("name") int name) {
		String[] allPlayers = new String[] {};
		return new GameBoard(5, 5, allPlayers);
	}

	@RequestMapping(value = "/gameboards/{boardName}/players/{playerName}/column/{columnIndex}", method = RequestMethod.GET)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "Name of the gameboard", required = true, dataType = "String") })
	public @ResponseBody GameBoard addGameboardMove(@PathVariable("boardName") String boardName,
			@PathVariable("playerName") String playerName, @PathVariable("columnIndex") int columnIndex) {

		GameBoard gameBoardFindByName = gameBoardRepository.findByName(boardName);

		String[] allPlayers = gameBoardFindByName.getAllPlayers();
		int playerCount = -1;
		for (int i = 0; i < allPlayers.length; i++) {
			if (allPlayers[i].equals(playerName)) {
				playerCount = i;
			}
		}
		boolean moveForPlayer = gameBoardFindByName.moveForPlayer(playerCount, columnIndex);
		if(moveForPlayer){
			gameBoardFindByName.setWinner(playerCount);
		}
		gameBoardRepository.save(gameBoardFindByName);
		return gameBoardFindByName;
	}

	@RequestMapping(value = "/gameboards/", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ResponseEntity<GameBoard> getGameBoard(@RequestBody GameBoard gemeBoard) {
		GameBoard gameBoardFindByName = gameBoardRepository.findByName(gemeBoard.getName());

		if (gameBoardFindByName == null) {
			String[] allPlayers = gemeBoard.getAllPlayers();
			if (allPlayers.length > 2) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			for (String string : allPlayers) {
				if (playerRepository.findByName(string) == null) {
					playerRepository.save(new Player(string));
				}
			}
			return new ResponseEntity<GameBoard>(gameBoardRepository.save(gemeBoard), HttpStatus.ACCEPTED);

		} else {
			String[] allPlayers = gameBoardFindByName.getAllPlayers();
			if (allPlayers.length > 2) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			for (String string : allPlayers) {
				if (playerRepository.findByName(string) == null) {
					playerRepository.save(new Player(string));
				}
			}
			return new ResponseEntity<GameBoard>(gameBoardFindByName, HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(value = "/gameboards/{name}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<GameBoard> removeGameBoard(@PathVariable("name") String name) {
		GameBoard gameBoardFindByName = gameBoardRepository.findByName(name);
		if (gameBoardFindByName != null) {
			gameBoardRepository.delete(gameBoardFindByName);
			return new ResponseEntity<GameBoard>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<GameBoard>(HttpStatus.BAD_REQUEST);
		}
	}

}
