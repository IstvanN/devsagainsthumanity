package com.greenfoxacademy.dah.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hand_id")
  private Hand hand;

  private int score;
  private boolean canBid;
  private boolean canGiveCard;

  public Player(String name) {
    this.name = name;
  }
}
