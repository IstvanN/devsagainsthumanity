package com.greenfoxacademy.dah.controllers;

import com.greenfoxacademy.dah.services.GameRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cah/game")
public class GameRoomController {
  GameRoomService gameRoomService;

  @Autowired
  public GameRoomController(GameRoomService gameRoomService) {
    this.gameRoomService = gameRoomService;
  }
}
