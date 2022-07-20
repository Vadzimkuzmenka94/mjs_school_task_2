package com.epam.esm.service;

import com.epam.esm.DAO.TagDAOImpl;
import com.epam.esm.models.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TagServiceImpl implements TagService {
    private TagDAOImpl tagDAO;

    @Override
    public List<Tag> showAllTags() {
        return tagDAO.showAllTags();
    }

    @Override
    @Transactional
    public List<Tag> index() {
        return tagDAO.index();
    }

    @Override
    @Transactional
    public Tag show(int id) {
        return tagDAO.show(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        tagDAO.delete(id);
    }

    @Override
    @Transactional
    public void save(Tag tag) {
        tagDAO.save(tag);
    }
}