package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Reserve;
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
public class ReserveRepository implements JdbcRepository<Reserve, Long> {
    private final Logger logger = LoggerFactory.getLogger(ReserveRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReserveRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Reserve> findById(Long id) {
        List<Reserve> result = jdbcTemplate.query("SELECT * FROM reserve WHERE id = ?", reserveRowMapper(), id);
        logger.debug("Found reserve by id : {}", result);
        return result.stream().findAny();
    }

    @Override
    public List<Reserve> findAll() {
        return jdbcTemplate.query("SELECT * FROM reserve", reserveRowMapper());
    }

    @Override
    public void add(Reserve reserve) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("reserve").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", reserve.getUserId());
        parameters.put("room_id", reserve.getRoomId());
        parameters.put("check_in", reserve.getCheckIn());
        parameters.put("check_out", reserve.getCheckOut());
        parameters.put("guests", reserve.getGuests());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        reserve.setId(key.longValue());
    }

    @Override
    public void update(Reserve reserve) {
        jdbcTemplate.update("UPDATE reserve SET user_id = ?, room_id = ?, check_in = ?, check_out = ?, guests = ? WHERE id = ?",
                reserve.getUserId(), reserve.getRoomId(), reserve.getCheckIn(), reserve.getCheckOut(), reserve.getGuests(), reserve.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM reserve WHERE id = ?", id);
    }

    private RowMapper<Reserve> reserveRowMapper() {
        return (rs, rowNum) -> {
            Reserve reserve = new Reserve();
            reserve.setId(rs.getLong("id"));
            reserve.setUserId(rs.getString("user_id"));
            reserve.setRoomId(rs.getLong("room_id"));
            reserve.setCheckIn(rs.getString("check_in"));
            reserve.setCheckOut(rs.getString("check_out"));
            reserve.setGuests(rs.getInt("guests"));
            return reserve;
        };
    }
}
