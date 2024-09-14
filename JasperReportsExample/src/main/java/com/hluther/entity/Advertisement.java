package com.hluther.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Advertisement {

    private Long id;
    private String owner;
    private String title;
    private AdvertisementType type;
    private BigDecimal price;
    private Date startDate;
    private AdvertisementDuration duration;
    private Boolean active;

    public Advertisement() {
    }

    public Advertisement(Long id, String owner, String title, AdvertisementType type, BigDecimal price, Date startDate, AdvertisementDuration duration, Boolean active) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.duration = duration;
        this.active = active;
    }

    public AdvertisementType getType() {
        return type;
    }

    public void setType(AdvertisementType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public AdvertisementDuration getDuration() {
        return duration;
    }

    public void setDuration(AdvertisementDuration duration) {
        this.duration = duration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return type.name();
    }

    public String getDurationTranslate() {
        switch (duration) {
            case ONE_DAY:
                return "1 día";
            case THREE_DAYS:
                return "3 días";
            case ONE_WEEK:
                return "1 semana";
            case TWO_WEEKS:
                return "2 semanas";
            default:
                return "";
        }
    }
}
