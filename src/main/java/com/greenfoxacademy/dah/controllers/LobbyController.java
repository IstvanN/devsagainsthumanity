package com.greenfoxacademy.dah.controllers;

import java.util.ArrayList;
import java.util.List;

import com.greenfoxacademy.dah.models.Lobby;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cah/game")
public class LobbyController {
    List<Lobby> lobbies = new ArrayList<>();

    @GetMapping(value = { "", "/" })
    public String showIndex() {
        return "index";
    }

    @PostMapping("/createLobby")
    public String createLobby(@RequestParam("creatorName") String creatorName,
                              @RequestParam("lobbyName") String lobbyName) {
        Lobby lobby = new Lobby(lobbyName, creatorName);
        lobbies.add(lobby);
        return "redirect:/" + lobby.getId() + "/lobby/";
    }

    @GetMapping("/{id}/lobby/")
    public String showLobby(@PathVariable("id") int id, Model model) {
        Lobby lobby = getLobbyById(id);
        model.addAttribute("lobby", lobby);
        return "lobby";
    }

    private Lobby getLobbyById(int id) {
        for (Lobby lobby : lobbies) {
            if (lobby.getId() == id) {
                return lobby;
            }
        }
        return null;
    }
}