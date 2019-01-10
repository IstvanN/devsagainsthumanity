package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
}
