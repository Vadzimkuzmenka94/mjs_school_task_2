package com.epam.esm.DAO;

import com.epam.esm.models.GiftSertificate;

import java.util.List;

public interface GiftSertificateDAO {

    List<GiftSertificate> showAllGiftSertificate();

    List<GiftSertificate> index();

    GiftSertificate show(int id);

    void save(GiftSertificate giftSertificate);

    void update(int id, GiftSertificate updateGiftSertificate);

    void delete(int id);
}