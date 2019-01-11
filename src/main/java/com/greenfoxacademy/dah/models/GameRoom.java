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
public class GameRoom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @OneToMany
  private List<Player> playerList;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deck_id")
  private Deck deck;
}
