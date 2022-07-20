package com.epam.esm.DAO;

import com.epam.esm.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    private static class TagRowMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tag newTag = new Tag();
            newTag.setTag_name(rs.getString("tag_name"));
            return newTag;
        }
    }

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> showAllTags() {
        return jdbcTemplate.query("SELECT * FROM tags", new Object[]{}, new TagDAOImpl.TagRowMapper());
    }

    @Override
    public List<Tag> index() {
        return jdbcTemplate.query("SELECT * FROM tags", new TagRowMapper());
    }

    @Override
    public Tag show(int id) {
        return jdbcTemplate.query("SELECT * FROM tags WHERE tag_id=?", new Object[]{id}, new TagRowMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Tag WHERE tag_id=?", id);
    }

    @Override
    public void save(Tag tag) {
        jdbcTemplate.update("INSERT INTO Tag(tagName) VALUES (?)", tag.getTag_name());
    }
}