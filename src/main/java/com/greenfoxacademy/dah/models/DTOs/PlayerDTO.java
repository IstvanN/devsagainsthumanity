package com.greenfoxacademy.dah.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDTO {
    private long id;
    private String name;
    private HandDTO handDTO;
    private int score;
    private boolean canBid;
    private boolean canGiveCard;
}
