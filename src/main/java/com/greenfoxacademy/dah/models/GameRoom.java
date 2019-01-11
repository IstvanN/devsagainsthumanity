package com.greenfoxacademy.dah.models;

import com.greenfoxacademy.dah.services.CardLogic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int genereatedId;

    private String name;

    @OneToMany
    private List<Player> playerList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private Deck deck;

    public GameRoom(int generatedId) {
        this.genereatedId = generatedId;
        this.playerList = new ArrayList<>();
        this.deck = new Deck();
    }
}
