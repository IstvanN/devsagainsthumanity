package com.greenfoxacademy.dah.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deck {

    private List<BlackCard> blackCards;
    private List<WhiteCard> whiteCards;
}
