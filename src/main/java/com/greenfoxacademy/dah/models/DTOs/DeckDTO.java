package com.greenfoxacademy.dah.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeckDTO {
    private long id;
    private List<BlackCardDTO> blackCardDTOList;
    private List<WhiteCardDTO> whiteCardDTOList;
}
