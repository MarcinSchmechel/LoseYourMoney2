package com.game.LoseYourMoney2.repository;

import com.game.LoseYourMoney2.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    List<User> findByLastName(String lastName);
}
