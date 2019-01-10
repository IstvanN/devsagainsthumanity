package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.BlackCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlackCardRepository extends CrudRepository<BlackCard, Long> {

    List<BlackCard> findAll();
    BlackCard findById(long id);
}
