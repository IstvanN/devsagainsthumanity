package com.greenfoxacademy.dah.services;

import com.greenfoxacademy.dah.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameRoomService {
  GameRoomRepository gameRoomRepository;
  PlayerRepository playerRepository;
  DeckRepository deckRepository;
  HandRepository handRepository;
  BlackCardRepository blackCardRepository;
  WhiteCardRepository whiteCardRepository;

  @Autowired
  public GameRoomService(GameRoomRepository gameRoomRepository, PlayerRepository playerRepository, DeckRepository deckRepository, HandRepository handRepository, BlackCardRepository blackCardRepository, WhiteCardRepository whiteCardRepository) {
    this.gameRoomRepository = gameRoomRepository;
    this.playerRepository = playerRepository;
    this.deckRepository = deckRepository;
    this.handRepository = handRepository;
    this.blackCardRepository = blackCardRepository;
    this.whiteCardRepository = whiteCardRepository;
  }
}
