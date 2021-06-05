package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Room;
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
class RoomRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(RoomRepositoryTest.class);

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void test_findById() {
        Room room = roomRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found room by id : {}", room);
        assertThat(1L).isEqualTo(room.getId());
    }

    @Test
    void test_findAll() {
        List<Room> rooms = roomRepository.findAll();
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            logger.info("Found room : {}", room);
            assertThat((long) (i + 1)).isEqualTo(room.getId());
        }
    }

    @Test
    void test_add() {
        Room room = new Room(5L, "대구", "조촐한 나의 집", "image_url", "최대 인원 5명 ・ 거실 ・ 욕실 2개 ・ 주방", "35.123143123", "23.65343322",
                3.5, 214, 58302, 23251, 342212, 28803);
        roomRepository.add(room);

        Room insertedRoom = roomRepository
                .findById(5L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted room : {}", insertedRoom);
        assertThat("대구").isEqualTo(insertedRoom.getLocation());
    }

    @Test
    void test_update() {
        Room room = new Room(1L, "대구", "조촐한 나의 집", "image_url", "최대 인원 5명 ・ 거실 ・ 욕실 2개 ・ 주방", "35.123143123", "23.65343322",
                3.5, 214, 58302, 23251, 342212, 28803);
        roomRepository.update(room);

        Room updatedRoom = roomRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Updated room : {}", updatedRoom);
        assertThat("대구").isEqualTo(updatedRoom.getLocation());
    }

    @Test
    void test_delete() {
        Room room = new Room(6L, "대구", "조촐한 나의 집", "image_url", "최대 인원 5명 ・ 거실 ・ 욕실 2개 ・ 주방", "35.123143123", "23.65343322",
                3.5, 214, 58302, 23251, 342212, 28803);
        roomRepository.add(room);

        List<Room> rooms = roomRepository.findAll();
        logger.info("Before deleted : {}", rooms);
        roomRepository.delete(6L);
        List<Room> deletedRooms = roomRepository.findAll();
        logger.info("After deleted : {}", deletedRooms);
        assertThat(rooms.size()).isEqualTo(deletedRooms.size() + 1);
    }
}
