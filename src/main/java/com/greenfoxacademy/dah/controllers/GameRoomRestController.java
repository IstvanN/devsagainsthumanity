package com.greenfoxacademy.dah.controllers;

import com.greenfoxacademy.dah.models.DTOs.PlayerDTO;
import com.greenfoxacademy.dah.services.GameRoomService;
import com.greenfoxacademy.dah.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cah/game")
public class GameRoomRestController {
    GameRoomService gameRoomService;
    LobbyService lobbyService;

    @Autowired
    public GameRoomRestController(GameRoomService gameRoomService, LobbyService lobbyService) {
        this.gameRoomService = gameRoomService;
        this.lobbyService = lobbyService;
    }

    @GetMapping(value = "/{gameId}/{playerId}/players", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlayerDTO> getPlayerNamesJSON(@PathVariable(value = "playerId") long playerId,
                                              @PathVariable("gameId") int gameId) {
        List<PlayerDTO> playerDTOList = gameRoomService.getPlayerDTOList(gameRoomService.getGameRoomByGeneratedId(gameId));
        return playerDTOList;
    }
}
