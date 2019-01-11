package com.greenfoxacademy.dah.controllers;

import com.greenfoxacademy.dah.models.DTOs.GameRoomDTO;
import com.greenfoxacademy.dah.models.DTOs.PlayerDTO;
import com.greenfoxacademy.dah.models.GameRoom;
import com.greenfoxacademy.dah.models.Player;
import com.greenfoxacademy.dah.services.GameRoomService;
import com.greenfoxacademy.dah.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cah/game")
public class GameRoomController {
    GameRoomService gameRoomService;
    LobbyService lobbyService;

    @Autowired
    public GameRoomController(GameRoomService gameRoomService, LobbyService lobbyService) {
        this.gameRoomService = gameRoomService;
        this.lobbyService = lobbyService;
    }

    @GetMapping("/{gameId}/{playerId}/game-start")
    public String gameStarter(@PathVariable(value = "playerId") long playerId,
                              @PathVariable("gameId") int gameId) {
        return "game-start";
    }

    @GetMapping(value = "/{gameId}/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGamePage(@PathVariable(value = "playerId") long playerId,
                              @PathVariable("gameId") int gameId) {
        if (!gameRoomService.doesGameRoomAlreadyExists(gameId)) {
            GameRoom gameRoom = gameRoomService.createGameRoom(gameId);
            Player player = lobbyService.getPlayerById(playerId);

            gameRoomService.addPlayerToGameRoom(gameRoom, player);
        } else {
            GameRoom gameRoom = gameRoomService.getGameRoomByGeneratedId(gameId);
            Player player = lobbyService.getPlayerById(playerId);

            gameRoomService.addPlayerToGameRoom(gameRoom, player);
        }
        return "game";
    }
}
