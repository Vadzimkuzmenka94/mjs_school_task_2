package com.epam.esm.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Time;

public class GiftSertificate {

    private int sertificate_id;
    @NotEmpty(message = "sertificate name can't be empty")
    @Size(min = 2, max = 30)
    private String sertificate_name;
    @NotEmpty(message = "description can't be empty")
    private String description;
    @NotEmpty(message = "price can't be empty")
    private int price;
    @NotEmpty(message = "duration can't be empty")
    private int duration;
    @NotEmpty(message = "create date can't be empty")
    private Time create_date;
    @NotEmpty(message = "last update data can't be empty")
    private Time last_update_data;

    public GiftSertificate(int sertificate_id, String sertificate_name, String description, int price, int duration, Time create_date, Time last_update_data) {
        this.sertificate_id = sertificate_id;
        this.sertificate_name = sertificate_name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.create_date = create_date;
        this.last_update_data = last_update_data;
    }

    public GiftSertificate() {
    }

    public int getSertificate_id() {
        return sertificate_id;
    }

    public void setSertificate_id(int sertificate_id) {
        this.sertificate_id = sertificate_id;
    }

    public String getSertificate_name() {
        return sertificate_name;
    }

    public void setSertificate_name(String sertificate_name) {
        this.sertificate_name = sertificate_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Time getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Time create_date) {
        this.create_date = create_date;
    }

    public Time getLast_update_data() {
        return last_update_data;
    }

    public void setLast_update_data(Time last_update_data) {
        this.last_update_data = last_update_data;
    }
}