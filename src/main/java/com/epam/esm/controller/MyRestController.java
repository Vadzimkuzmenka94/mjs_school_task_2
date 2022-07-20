package com.epam.esm.controller;

import com.epam.esm.models.GiftSertificate;
import com.epam.esm.models.Tag;
import com.epam.esm.service.GiftSertificateService;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private GiftSertificateService sertificateService;
    private TagService tagService;

    @GetMapping("/allSertificate")
    public List<GiftSertificate> showAllSertificate() {
        List<GiftSertificate> sertificateList = sertificateService.showAllGiftSertificate();
        return sertificateList;
    }

    @GetMapping("/allTags")
    public List<Tag> showAllTeg() {
        List<Tag> tagList = tagService.showAllTags();
        return tagList;
    }

    @GetMapping("/sertificate")
    public GiftSertificate showGiftSertificate(int id) {
        GiftSertificate sertificate = sertificateService.show(id);
        return sertificate;
    }

    @GetMapping("/tags")
    public Tag showTag(int id) {
        Tag tag = tagService.show(id);
        return tag;
    }

    @PostMapping("/sertificate")
    public GiftSertificate addGiftSertificate(@RequestBody GiftSertificate giftSertificate) {
        sertificateService.save(giftSertificate);
        return giftSertificate;
    }

    @PostMapping("/tags")
    public Tag addTag(@RequestBody Tag tag) {
        tagService.save(tag);
        return tag;
    }

    @PutMapping("/sertificate")
    public GiftSertificate updateGiftSertificate(@RequestBody GiftSertificate giftSertificate) {
        sertificateService.save(giftSertificate);
        return giftSertificate;
    }

    @DeleteMapping("/sertificate/{id}")
    public String deleteGiftSertificate(@PathVariable int id) {
        sertificateService.delete(id);
        return "Gift sertificate with id " + id + " was deleted";
    }

    @DeleteMapping("/tag/{id}")
    public String deleteTag(@PathVariable int id) {
        tagService.delete(id);
        return "Tag with id " + id + " was deleted";
    }
}