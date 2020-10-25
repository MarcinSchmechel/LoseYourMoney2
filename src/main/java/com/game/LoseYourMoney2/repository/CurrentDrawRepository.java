package com.game.LoseYourMoney2.repository;

import com.game.LoseYourMoney2.domain.CurrentDraw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CurrentDrawRepository extends CrudRepository<CurrentDraw, Integer> {
}
