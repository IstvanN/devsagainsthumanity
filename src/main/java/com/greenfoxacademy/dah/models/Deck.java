package com.greenfoxacademy.dah.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<BlackCard> blackCards;
    @OneToMany
    private List<WhiteCard> whiteCards;

    @OneToOne(mappedBy = "deck", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = false)
    private GameRoom gameRoom;
}
