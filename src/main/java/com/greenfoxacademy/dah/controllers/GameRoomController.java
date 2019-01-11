package com.greenfoxacademy.dah.controllers;

import com.greenfoxacademy.dah.models.Player;
import com.greenfoxacademy.dah.services.GameRoomService;
import com.greenfoxacademy.dah.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cah/game")
public class GameRoomController {
  GameRoomService gameRoomService;
  LobbyService lobbyService;

  @Autowired
  public GameRoomController(GameRoomService gameRoomService) {
    this.gameRoomService = gameRoomService;
  }

  @GetMapping("/{gameId}/{playerId}/game-start")
  public String gameStarter(@PathVariable(value = "playerId") long playerId,
                            @PathVariable("gameId") int gameId) {
    Player player = lobbyService.getPlayerById(playerId);

    return "redirect:/cah/game/" + gameId + "/" + player.getId();
  }

  @GetMapping(value = "/{gameId}/{playerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getGamePage(@PathVariable(value = "playerId") long playerId,
                            @PathVariable("gameId") int gameId, Model model) {
    // Model atts? JSON??
    return "game";
  }
}
