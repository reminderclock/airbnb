package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Reserve;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReserveRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(ReserveRepositoryTest.class);

    @Autowired
    private ReserveRepository reserveRepository;

    @Test
    void test_findById() {
        Reserve reserve = reserveRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found reserve by id : {}", reserve);
        assertThat(1L).isEqualTo(reserve.getId());
    }

    @Test
    void test_findAll() {
        List<Reserve> reserves = reserveRepository.findAll();
        for (int i = 0; i < reserves.size(); i++) {
            Reserve reserve = reserves.get(i);
            logger.info("Found reserve : {}", reserve);
            assertThat((long) (i + 1)).isEqualTo(reserve.getId());
        }
    }

    @Test
    void test_add() {
        Reserve reserve = new Reserve(5L, "august", 1L, "2021-08-10", "2021-08-17", 6);
        reserveRepository.add(reserve);

        Reserve insertedReserve = reserveRepository
                .findById(5L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted reserve : {}", insertedReserve);
        assertThat("august").isEqualTo(insertedReserve.getUserId());
    }

    @Test
    void test_update() {
        Reserve reserve = new Reserve(1L, "august", 1L, "2021-05-11", "2021-05-19", 4);
        reserveRepository.update(reserve);

        Reserve updatedReserve = reserveRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Updated reserve : {}", updatedReserve);
        assertThat("2021-05-11").isEqualTo(updatedReserve.getCheckIn());
    }

    @Test
    void test_delete() {
        List<Reserve> reserves = reserveRepository.findAll();
        logger.info("Before deleted : {}", reserves);
        reserveRepository.delete(1L);
        List<Reserve> deletedReserves = reserveRepository.findAll();
        logger.info("After deleted : {}", deletedReserves);
        assertThat(reserves.size()).isEqualTo(deletedReserves.size() + 1);
    }
}
