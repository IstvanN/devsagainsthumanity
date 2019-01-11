package com.greenfoxacademy.dah.services;

import com.greenfoxacademy.dah.models.BlackCard;
import com.greenfoxacademy.dah.models.Deck;
import com.greenfoxacademy.dah.models.Hand;
import com.greenfoxacademy.dah.models.WhiteCard;
import com.greenfoxacademy.dah.repositories.BlackCardRepository;
import com.greenfoxacademy.dah.repositories.DeckRepository;
import com.greenfoxacademy.dah.repositories.HandRepository;
import com.greenfoxacademy.dah.repositories.WhiteCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CardLogic {

    @Autowired
    WhiteCardRepository whiteCardRepository;
    @Autowired
    BlackCardRepository blackCardRepository;
    @Autowired
    DeckRepository deckRepository;
    @Autowired
    HandRepository handRepository;

    public Deck createDeck() {
        Deck deck = new Deck();
        shuffleDeckCards(deck);
        deckRepository.save(deck);

        return deck;
    }

    public Deck getDeck(long id) {
        return deckRepository.findById(id);
    }

    public Hand getHand(long id) {
        return handRepository.findById(id);
    }

    public Hand createHand(Deck deck) {
        Hand hand = new Hand();
        hand.setCards(pullWhiteCards(deck, 10));
        handRepository.save(hand);

        return hand;
    }

    private void shuffleDeckCards(Deck deck) {
        List<WhiteCard> whiteCards = whiteCardRepository.findAll();
        List<BlackCard> blackCards = blackCardRepository.findAll();
        Collections.shuffle(whiteCards);
        Collections.shuffle(blackCards);
        deck.setWhiteCards(whiteCards);
        deck.setBlackCards(blackCards);
    }

    public void addCardsToHand(Hand hand, List<WhiteCard> whiteCards) {
        List<WhiteCard> cardsInHand = hand.getCards();
        for (WhiteCard whiteCard : whiteCards) {
            cardsInHand.add(whiteCard);
        }
        hand.setCards(cardsInHand);
        handRepository.save(hand);
    }

    public void discardCardsFromHand(Hand hand, List<WhiteCard> whiteCards) {
        List<WhiteCard> cardsInHand = hand.getCards();
        for (WhiteCard whiteCard : whiteCards) {
            cardsInHand.remove(whiteCard);
        }
        hand.setCards(cardsInHand);
        handRepository.save(hand);
    }

    private List<WhiteCard> pullWhiteCards(Deck deck, int pullCount) {
        List<WhiteCard> cards = new ArrayList<>();
        for (int i = 0; i < pullCount; i++) {
            cards.add(deck.getWhiteCards().get(i));
        }
        discardWhiteCardsFromDeck(deck, cards);
        return cards;
    }

    public void discardWhiteCardsFromDeck(Deck deck, List<WhiteCard> cards) {
        List<WhiteCard> whiteCards = deck.getWhiteCards();
        for (WhiteCard card : cards) {
            whiteCards.remove(whiteCardRepository.findById(card.getId()));
        }
        deck.setWhiteCards(whiteCards);
        deckRepository.save(deck);
    }

    public BlackCard pullNextBlackCard(Deck deck) {
        List<BlackCard> blackCards = deck.getBlackCards();
        BlackCard nextBlack = blackCards.get(0);
        blackCards.remove(0);
        return nextBlack;
    }

}
