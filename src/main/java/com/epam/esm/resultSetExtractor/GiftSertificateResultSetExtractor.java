package com.epam.esm.resultSetExtractor;

import com.epam.esm.models.GiftSertificate;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiftSertificateResultSetExtractor implements ResultSetExtractor<List<GiftSertificate>> {
    @Override
    public List<GiftSertificate> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<GiftSertificate> giftSertificates = new ArrayList<>();
        while (rs.next()) {
            GiftSertificate giftSertificate = new GiftSertificate();
            giftSertificate.setSertificate_name(rs.getString("sertificate_name"));
            giftSertificate.setDescription(rs.getString("description"));
            giftSertificate.setPrice(rs.getInt("price"));
            giftSertificate.setDuration(rs.getInt("duration"));
            giftSertificate.setCreate_date(rs.getTime("create_date"));
            giftSertificate.setLast_update_data(rs.getTime("last_update_data"));
            giftSertificates.add(giftSertificate);
        }
        return giftSertificates;
    }
}