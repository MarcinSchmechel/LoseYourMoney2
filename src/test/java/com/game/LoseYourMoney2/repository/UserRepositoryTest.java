package com.game.LoseYourMoney2.repository;

import com.game.LoseYourMoney2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepositorySave() {
        //Given
        User user = new User("John", "Smith", "john@smith.com");

        //When
        userRepository.save(user);

        //Then
        int id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryFindByLastName() {
        //Given
        User user1 = new User("John", "Smith", "john@smith.com");
        User user2 = new User("John", "Colt", "john@smith.com");

        //When
        userRepository.save(user1);
        userRepository.save(user2);

        int id1 = user1.getId();
        int id2 = user2.getId();

        List<User> readUser = userRepository.findByLastName("Colt");

        //Then
        assertEquals(1, readUser.size());

        //CleanUp
        userRepository.deleteById(id1);
        userRepository.deleteById(id2);
    }
}