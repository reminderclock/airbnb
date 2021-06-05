package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.WishList;
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
class WishListRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(WishListRepositoryTest.class);

    @Autowired
    private WishListRepository wishListRepository;

    @Test
    void test_findById() {
        WishList wishList = wishListRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Found wishlist by id : {}", wishList);
        assertThat(1L).isEqualTo(wishList.getId());
    }

    @Test
    void test_findAll() {
        List<WishList> wishLists = wishListRepository.findAll();
        for (int i = 0; i < wishLists.size(); i++) {
            WishList wishList = wishLists.get(i);
            logger.info("Found wishList : {}", wishList);
            assertThat((long) (i + 1)).isEqualTo(wishList.getId());
        }
    }

    @Test
    void test_add() {
        WishList wishList = new WishList(5L, "august", 2L);
        wishListRepository.add(wishList);

        WishList insertedWishList = wishListRepository
                .findById(5L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Inserted wishlist : {}", insertedWishList);
        assertThat(2L).isEqualTo(insertedWishList.getRoomId());
    }

    @Test
    void test_update() {
        WishList wishList = new WishList(1L, "august", 3L);
        wishListRepository.update(wishList);

        WishList updatedWishList = wishListRepository
                .findById(1L)
                .orElseThrow(IllegalArgumentException::new);
        logger.info("Updated wishList : {}", updatedWishList);
        assertThat(3L).isEqualTo(updatedWishList.getRoomId());
    }

    @Test
    void test_delete() {
        List<WishList> wishLists = wishListRepository.findAll();
        logger.info("Before deleted : {}", wishLists);
        wishListRepository.delete(1L);
        List<WishList> deletedWishLists = wishListRepository.findAll();
        logger.info("After deleted : {}", deletedWishLists);
        assertThat(wishLists.size()).isEqualTo(deletedWishLists.size() + 1);
    }
}
