package com.epam.esm.DAO;


import com.epam.esm.models.GiftSertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GiftSertificateDAOImpl implements GiftSertificateDAO {

    private static class GiftSertificateRowMapper implements RowMapper<GiftSertificate> {

        @Override
        public GiftSertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
            GiftSertificate newGiftSertificate = new GiftSertificate();
            newGiftSertificate.setSertificate_name(rs.getString("sertificate_name"));
            newGiftSertificate.setDescription(rs.getString("description"));
            newGiftSertificate.setPrice(rs.getInt("price"));
            newGiftSertificate.setDuration(rs.getInt("duration"));
            newGiftSertificate.setCreate_date(rs.getTime("create_date"));
            newGiftSertificate.setLast_update_data(rs.getTime("last_update_data"));
            return newGiftSertificate;
        }
    }

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public GiftSertificateDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GiftSertificate> showAllGiftSertificate() {
        return jdbcTemplate.query("SELECT * FROM gift_sertificate", new Object[]{}, new GiftSertificateRowMapper());
    }

    @Override
    public List<GiftSertificate> index() {
        return jdbcTemplate.query("SELECT * FROM gift_sertificate", new GiftSertificateRowMapper());
    }

    @Override
    public GiftSertificate show(int id) {
        return jdbcTemplate.query("SELECT * FROM gift_sertificate WHERE sertificate_id=?", new Object[]{id},
                        new GiftSertificateRowMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void save(GiftSertificate giftSertificate) {
        jdbcTemplate.update("INSERT INTO gift_sertificate(sertificate_name, description, price," +
                        " duration, create_date, last_update_data) VALUES (?,?,?,?,?,?)",
                giftSertificate.getSertificate_name(),
                giftSertificate.getDescription(),
                giftSertificate.getPrice(),
                giftSertificate.getDuration(),
                giftSertificate.getCreate_date(),
                giftSertificate.getLast_update_data());
    }

    @Override
    public void update(int id, GiftSertificate updateGiftSertificate) {
        jdbcTemplate.update("UPDATE gift_sertificate SET sertificate_name=?, description=?, price=?, duration=?, " +
                        "create_date=?, last_update_data=? WHERE sertificate_id=?",
                updateGiftSertificate.getSertificate_name(),
                updateGiftSertificate.getDescription(),
                updateGiftSertificate.getPrice(),
                updateGiftSertificate.getDuration(),
                updateGiftSertificate.getCreate_date(),
                updateGiftSertificate.getLast_update_data(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM gift_sertificate WHERE sertificate_id=?", id);
    }
}