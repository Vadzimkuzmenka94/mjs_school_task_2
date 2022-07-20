package com.epam.esm.DAO;

import com.epam.esm.models.GiftSertificate;
import com.epam.esm.models.Tag;

import java.util.List;

public interface TagDAO {
    List<Tag> showAllTags();

    List<Tag> index();

    Tag show(int id);

    void delete(int id);

    public void save(Tag tag);
}