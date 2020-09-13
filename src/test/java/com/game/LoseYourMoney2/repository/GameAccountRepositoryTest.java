package com.game.LoseYourMoney2.repository;

import com.game.LoseYourMoney2.domain.GameAccount;
import com.game.LoseYourMoney2.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameAccountRepositoryTest {
    @Autowired
    private GameAccountRepository gameAccountRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGameAccountRepositorySave(){
        //Given
        GameAccount gameAccount = new GameAccount(1500);

        //When
        gameAccountRepository.save(gameAccount);

        //Then
        int id = gameAccount.getId();
        Optional<GameAccount> readAccount = gameAccountRepository.findById(id);
        assertTrue(readAccount.isPresent());

        //CleanUp
        gameAccountRepository.deleteById(id);
    }

    @Test
    public void testGameAccountRepositorySaveWithUser(){
        //Given
        GameAccount gameAccount = new GameAccount(2000);
        User user = new User("B", "At", "kent@smith.com");
        gameAccount.setUser(user);

        //When
        gameAccountRepository.save(gameAccount);
        int id = gameAccount.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        gameAccountRepository.deleteById(id);
    }
}