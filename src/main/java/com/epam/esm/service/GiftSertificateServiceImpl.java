package com.epam.esm.service;

import com.epam.esm.DAO.GiftSertificateDAOImpl;
import com.epam.esm.models.GiftSertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GiftSertificateServiceImpl implements GiftSertificateService {

    @Autowired
    private GiftSertificateDAOImpl giftSertificateDAO;

    @Override
    @Transactional
    public List<GiftSertificate> index() {
        return giftSertificateDAO.index();
    }

    @Override
    @Transactional
    public GiftSertificate show(int id) {
        return giftSertificateDAO.show(id);
    }

    @Override
    @Transactional
    public List<GiftSertificate> showAllGiftSertificate() {
        return giftSertificateDAO.showAllGiftSertificate();
    }

    @Override
    @Transactional
    public void save(GiftSertificate giftSertificate) {
        giftSertificateDAO.save(giftSertificate);
    }

    @Override
    @Transactional
    public void update(int id, GiftSertificate updateGiftSertificate) {
        giftSertificateDAO.update(id, updateGiftSertificate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        giftSertificateDAO.delete(id);
    }
}