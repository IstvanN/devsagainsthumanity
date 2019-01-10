package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.WhiteCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiteCardRepository extends CrudRepository<WhiteCard, Long> {

    List<WhiteCard> findAll();
}
