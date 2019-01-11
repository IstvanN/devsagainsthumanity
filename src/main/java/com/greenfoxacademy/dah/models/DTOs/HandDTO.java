package com.greenfoxacademy.dah.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HandDTO {
    private long id;
    private List<WhiteCardDTO> whiteCardDTOList;
}
