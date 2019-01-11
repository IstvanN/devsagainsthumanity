package com.greenfoxacademy.dah.services;

import com.greenfoxacademy.dah.models.Lobby;
import com.greenfoxacademy.dah.models.Player;
import com.greenfoxacademy.dah.repositories.LobbyRepository;
import com.greenfoxacademy.dah.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LobbyService {
    PlayerRepository playerRepository;
    LobbyRepository lobbyRepository;

    @Autowired
    public LobbyService(PlayerRepository playerRepository, LobbyRepository lobbyRepository) {
        this.playerRepository = playerRepository;
        this.lobbyRepository = lobbyRepository;
    }

    public Lobby createNewLobby(String lobbyName) {
        Lobby lobby = new Lobby(lobbyName);
        lobbyRepository.save(lobby);

        return lobby;
    }

    public Player createPlayer(String name) {
        Player player = new Player(name);
        playerRepository.save(player);

        return player;
    }

    public void addPlayerToLobby(Lobby lobby, Player player) {
        lobby.getPlayerList().add(player);
    }

    public Player getPlayerById(long playerId) {
        return playerRepository.findById(playerId);
    }

    public Lobby getLobbyByGeneratedId(int generatedId) {
        return lobbyRepository.getByGeneratedId(generatedId);
    }

    public List<String> getPlayerNames() {
        List<String> nameList = new ArrayList();
        List<Player> playerList = playerRepository.findAll();

        playerList.forEach(player -> nameList.add(player.getName()));

        return nameList;
    }

    public Player getPlayerByName(String playerName) {
        return playerRepository.findFirstByName(playerName);
    }

    public boolean checkIfLobbyIsStartable(int existingLobbyId) {
        boolean isEveryOneReady = true;
        Lobby lobby = lobbyRepository.getByGeneratedId(existingLobbyId);

        for (int i = 0; i <= lobby.getPlayerList().size(); i++) {
            if (lobby.getPlayerList().get(i).isReady() == false) {
                isEveryOneReady = false;
            }
        }

        lobby.setStartable(isEveryOneReady);
        return lobby.isStartable();
    }
}
