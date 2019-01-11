package com.greenfoxacademy.dah.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GameRoomDTO {
    private int generatedId;
    private String name;
    private List<PlayerDTO> playerDTOList;
    private DeckDTO deckDTO;
}
