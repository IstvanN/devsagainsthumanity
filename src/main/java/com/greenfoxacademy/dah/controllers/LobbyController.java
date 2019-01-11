package com.greenfoxacademy.dah.controllers;

import java.util.ArrayList;
import java.util.List;

import com.greenfoxacademy.dah.models.Lobby;

import com.greenfoxacademy.dah.models.Player;
import com.greenfoxacademy.dah.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cah/game")
public class LobbyController {
    LobbyService lobbyService;

    @Autowired
    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @GetMapping(value = { "", "/" })
    public String showIndex() {
        return "index";
    }

    @PostMapping("/create-lobby")
    public String createLobby(@RequestParam(value = "creatorName") String creatorName,
                              @RequestParam("lobbyName") String lobbyName) {
        Lobby lobby = lobbyService.createNewLobby(lobbyName);
        Player player = lobbyService.createPlayer(creatorName);
        lobbyService.addPlayerToLobby(lobby, player);

        return "redirect:/cah/game/" + lobby.getGeneratedId() + "/" + player.getId() + "/lobby/";
    }

    @GetMapping("/{lobbyId}/{playerId}/lobby/")
    public String showLobby(@PathVariable("lobbyId") int lobbyId,
                            @PathVariable("playerId") long playerId, Model model) {
        Lobby lobby = lobbyService.getLobbyByGeneratedId(lobbyId);
        Player player = lobbyService.getPlayerById(playerId);
        List<String> playerNames = lobbyService.getPlayerNames();

        model.addAttribute("lobby", lobby);
        model.addAttribute("playerNames", playerNames);
        model.addAttribute("playerId", player.getId());

        return "lobby";
    }

    @PostMapping("/join-lobby")
    public String createLobby(@RequestParam(value = "playerName") String playerName,
                              @RequestParam("existingLobbyId") int existingLobbyId) {
        if (lobbyService.getLobbyByGeneratedId(existingLobbyId) != null) {
            Player player = lobbyService.createPlayer(playerName);
            lobbyService.getLobbyByGeneratedId(existingLobbyId).getPlayerList().add(player);

            return "redirect:/cah/game/" + existingLobbyId + "/" + player.getId() + "/lobby";
        }
        return "redirect:/cah/game/";
    }

    @PostMapping("/set-player-ready")
    public String getIsReadyData(@RequestParam(value = "playerName") String playerName,
                                 @RequestParam("existingLobbyId") int existingLobbyId) {
        Player player = lobbyService.getPlayerByName(playerName);
        player.setReady(true);

        if (lobbyService.checkIfEveryoneIsReady(existingLobbyId)) {
            return "/" + existingLobbyId + "/" + player.getId() + "/game-start";
        }
        return "redirect:/cah/game/" + existingLobbyId + "/" + player.getId() + "/lobby";
    }
}