package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements JdbcRepository<User, String> {
    private final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(String id) {
        List<User> result = jdbcTemplate.query("SELECT * FROM user WHERE id = ?", userRowMapper(), id);
        logger.debug("Found user by id : {}", result);
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user", userRowMapper());
    }

    @Override
    public void add(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", user.getId());
        parameters.put("password", user.getPassword());
        parameters.put("nickname", user.getNickname());
        parameters.put("email", user.getEmail());

        jdbcInsert.execute(parameters);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE user SET password = ?, nickname = ?, email = ? WHERE id = ?",
                user.getPassword(), user.getNickname(), user.getEmail(), user.getId());
    }

    @Override
    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            return user;
        };
    }
}
