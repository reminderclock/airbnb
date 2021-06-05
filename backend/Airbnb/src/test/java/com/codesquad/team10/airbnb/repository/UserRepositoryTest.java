package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.User;
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
class UserRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_findById() {
        User user = userRepository
                .findById("august")
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found user by id : {}", user);
        assertThat("august").isEqualTo(user.getId());
    }

    @Test
    void test_findAll() {
        List<User> users = userRepository.findAll();
        assertThat("august").isEqualTo(users.get(0).getId());
        assertThat("luke").isEqualTo(users.get(1).getId());
        assertThat("ray").isEqualTo(users.get(2).getId());
        assertThat("team10").isEqualTo(users.get(3).getId());
    }

    @Test
    void test_add() {
        User user = new User("test", "1234", "testing", "test@test.com");
        userRepository.add(user);

        User insertedUser = userRepository
                .findById("test")
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted user : {}", insertedUser);
        assertThat("test").isEqualTo(insertedUser.getId());
    }

    @Test
    void test_update() {
        User user = new User("august", "1234", "nickname", "august@codesquad.com");
        userRepository.update(user);

        User updatedUser = userRepository
                .findById("august")
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Updated user : {}", updatedUser);
        assertThat("nickname").isEqualTo(updatedUser.getNickname());
    }

    @Test
    void test_delete() {
        User user = new User("test", "1234", "testing", "test@test.com");
        userRepository.add(user);

        List<User> users = userRepository.findAll();
        logger.info("Before deleted : {}", users);
        userRepository.delete("test");
        List<User> deletedUsers = userRepository.findAll();
        logger.info("After deleted : {}", deletedUsers);
        assertThat(users.size()).isEqualTo(deletedUsers.size() + 1);
    }
}
