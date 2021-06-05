package com.codesquad.team10.airbnb.repository;

import com.codesquad.team10.airbnb.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoomRepository implements JdbcRepository<Room, Long> {
    private final Logger logger = LoggerFactory.getLogger(RoomRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RoomRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Room> findById(Long id) {
        List<Room> result = jdbcTemplate.query("SELECT * FROM room WHERE id = ?", roomRowMapper(), id);
        logger.debug("Found room by id : {}", result);
        return result.stream().findAny();
    }

    @Override
    public List<Room> findAll() {
        return jdbcTemplate.query("SELECT * FROM room", roomRowMapper());
    }

    @Override
    public void add(Room room) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("room").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("location", room.getLocation());
        parameters.put("title", room.getTitle());
        parameters.put("image", room.getImage());
        parameters.put("description", room.getDescription());
        parameters.put("x_pos", room.getxPos());
        parameters.put("y_pos", room.getyPos());
        parameters.put("ratings", room.getRatings());
        parameters.put("reviews", room.getReviews());
        parameters.put("charge", room.getCharge());
        parameters.put("cleaning_fee", room.getCleaningFee());
        parameters.put("service_fee", room.getServiceFee());
        parameters.put("tax_fee", room.getTaxFee());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        room.setId(key.longValue());
    }

    @Override
    public void update(Room room) {
        jdbcTemplate.update("UPDATE room SET location = ?, title = ?, image = ?, description = ?, x_pos = ?, y_pos = ?, ratings = ?, reviews = ?, charge = ?, cleaning_fee = ?, service_fee = ?, tax_fee = ? WHERE id = ?",
                room.getLocation(), room.getTitle(), room.getImage(), room.getDescription(), room.getxPos(), room.getyPos(), room.getRatings(), room.getReviews(), room.getCharge(), room.getCleaningFee(), room.getServiceFee(), room.getTaxFee(), room.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM room WHERE id = ?", id);
    }

    private RowMapper<Room> roomRowMapper() {
        return (rs, rowNum) -> {
            Room room = new Room();
            room.setId(rs.getLong("id"));
            room.setLocation(rs.getString("location"));
            room.setTitle(rs.getString("title"));
            room.setImage(rs.getString("image"));
            room.setDescription(rs.getString("description"));
            room.setxPos(rs.getString("x_pos"));
            room.setyPos(rs.getString("y_pos"));
            room.setRatings(rs.getDouble("ratings"));
            room.setReviews(rs.getInt("reviews"));
            room.setCharge(rs.getInt("charge"));
            room.setCleaningFee(rs.getInt("cleaning_fee"));
            room.setServiceFee(rs.getInt("service_fee"));
            room.setTaxFee(rs.getInt("tax_fee"));
            return room;
        };
    }
}
