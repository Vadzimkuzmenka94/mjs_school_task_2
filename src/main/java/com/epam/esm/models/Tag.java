package com.epam.esm.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Tag {

    private int tag_id;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String tag_name;

    public Tag(int tagId, String tagName) {
        this.tag_id = tagId;
        this.tag_name = tagName;
    }

    public Tag() {
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}