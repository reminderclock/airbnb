package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.WishList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class WishListRepository implements JdbcRepository<WishList, Long> {
    private final Logger logger = LoggerFactory.getLogger(WishListRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public WishListRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<WishList> findById(Long id) {
        List<WishList> result = jdbcTemplate.query("SELECT * FROM wishlist WHERE id = ?", wishListRowMapper(), id);
        logger.debug("Found wishlist by id : {}", result);
        return result.stream().findAny();
    }

    @Override
    public List<WishList> findAll() {
        return jdbcTemplate.query("SELECT * FROM wishlist", wishListRowMapper());
    }

    @Override
    public void add(WishList wishList) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("wishlist").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", wishList.getUserId());
        parameters.put("room_id", wishList.getRoomId());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        wishList.setId(key.longValue());
    }

    @Override
    public void update(WishList wishList) {
        jdbcTemplate.update("UPDATE wishlist SET user_id = ?, room_id = ? WHERE id = ?",
                wishList.getUserId(), wishList.getRoomId(), wishList.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM wishlist WHERE id = ?", id);
    }

    private RowMapper<WishList> wishListRowMapper() {
        return (rs, rowNum) -> {
            WishList wishList = new WishList();
            wishList.setId(rs.getLong("id"));
            wishList.setUserId(rs.getString("user_id"));
            wishList.setRoomId(rs.getLong("room_id"));
            return wishList;
        };
    }
}
