package com.game.LoseYourMoney2.repository;

import com.game.LoseYourMoney2.domain.LotteryArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryArchiveRepositoryTest {
    @Autowired
    private LotteryArchiveRepository lotteryArchiveRepository;

    @Test
    public void testLotteryArchiveRepositorySave() {
        //Given
        LotteryArchive lotteryArchive = new LotteryArchive(1, 5);

        //When
        lotteryArchiveRepository.save(lotteryArchive);

        //Then
        int id = lotteryArchive.getId();
        Optional<LotteryArchive> readLottery = lotteryArchiveRepository.findById(id);
        assertTrue(readLottery.isPresent());

        //CleanUp
        lotteryArchiveRepository.deleteById(id);
    }
}