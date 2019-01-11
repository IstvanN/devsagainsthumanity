package com.greenfoxacademy.dah.services;

import com.greenfoxacademy.dah.models.DTOs.HandDTO;
import com.greenfoxacademy.dah.models.DTOs.PlayerDTO;
import com.greenfoxacademy.dah.models.DTOs.WhiteCardDTO;
import com.greenfoxacademy.dah.models.GameRoom;
import com.greenfoxacademy.dah.models.Hand;
import com.greenfoxacademy.dah.models.Player;
import com.greenfoxacademy.dah.models.WhiteCard;
import com.greenfoxacademy.dah.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameRoomService {
    GameRoomRepository gameRoomRepository;
    PlayerRepository playerRepository;
    CardLogic cardLogic;

    @Autowired
    public GameRoomService(GameRoomRepository gameRoomRepository, PlayerRepository playerRepository, CardLogic cardLogic) {
        this.gameRoomRepository = gameRoomRepository;
        this.playerRepository = playerRepository;
        this.cardLogic = cardLogic;
    }

    public boolean doesGameRoomAlreadyExists(int gameId) {
        return (getGameRoomByGeneratedId(gameId) != null);
    }

    public GameRoom getGameRoomByGeneratedId(int gameId) {
        return gameRoomRepository.getByGenereatedId(gameId);
    }

    public GameRoom createGameRoom(int gameId) {
        GameRoom gameRoom = new GameRoom(gameId);
        gameRoom.setDeck(cardLogic.createDeck());
        gameRoomRepository.save(gameRoom);

        return gameRoom;
    }

    public void addPlayerToGameRoom(GameRoom gameRoom, Player player) {
//        player.setHand(cardLogic.createHand(gameRoom.getDeck()));
        gameRoom.getPlayerList().add(player);

        gameRoomRepository.save(gameRoom);
    }

    public List<PlayerDTO> getPlayerDTOList(GameRoom gameRoom) {
        List<PlayerDTO> playerDTOList = new ArrayList<>();

        for(Player player : gameRoom.getPlayerList()) {
            playerDTOList.add(playerToPlayerDTOConverter(player));
        }

        return playerDTOList;
    }

    public PlayerDTO playerToPlayerDTOConverter(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setScore(player.getScore());
        playerDTO.setCanBid(player.isCanBid());
        playerDTO.setCanGiveCard(player.isCanGiveCard());
        playerDTO.setHandDTO(handToHandDTOConverter(player.getHand()));

        return playerDTO;
    }

    private HandDTO handToHandDTOConverter(Hand hand) {
        HandDTO handDTO = new HandDTO();

//        handDTO.setId(hand.getId());
//        if (hand.getCards() != null) {
//            for (WhiteCard card : hand.getCards()) {
//                handDTO.getWhiteCardDTOList().add(whiteCardToWhiteCardDTO(card));
//            }
//        }
        return handDTO;
    }

    private WhiteCardDTO whiteCardToWhiteCardDTO(WhiteCard whiteCard) {
        WhiteCardDTO whiteCardDTO = new WhiteCardDTO();

        whiteCardDTO.setId(whiteCard.getId());
        whiteCardDTO.setText(whiteCard.getText());

        return whiteCardDTO;
    }
}
