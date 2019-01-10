package com.greenfoxacademy.dah.services;

import com.greenfoxacademy.dah.models.BlackCard;
import com.greenfoxacademy.dah.models.Deck;
import com.greenfoxacademy.dah.models.WhiteCard;
import com.greenfoxacademy.dah.repositories.BlackCardRepository;
import com.greenfoxacademy.dah.repositories.DeckRepository;
import com.greenfoxacademy.dah.repositories.WhiteCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    WhiteCardRepository whiteCardRepository;
    @Autowired
    BlackCardRepository blackCardRepository;
    @Autowired
    DeckRepository deckRepository;

    public Deck createDeck() {
        Deck deck = new Deck();
        shuffleDeckCards(deck);
        deckRepository.save(deck);
        return deck;
    }

    private void shuffleDeckCards(Deck deck) {
        List<WhiteCard> whiteCards = whiteCardRepository.findAll();
        List<BlackCard> blackCards = blackCardRepository.findAll();
        Collections.shuffle(whiteCards);
        Collections.shuffle(blackCards);
        deck.setWhiteCards(whiteCards);
        deck.setBlackCards(blackCards);
    }

}
