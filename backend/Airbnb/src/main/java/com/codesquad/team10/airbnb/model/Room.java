package com.codesquad.team10.airbnb.model;

import org.springframework.data.annotation.Id;

public class Room {
    @Id
    private Long id;

    private String location;
    private String title;
    private String image;
    private String description;
    private String xPos;
    private String yPos;
    private Double ratings;
    private Integer reviews;
    private Integer charge;
    private Integer cleaningFee;
    private Integer serviceFee;
    private Integer taxFee;

    public Room() {
    }

    public Room(Long id, String location, String title, String image, String description, String xPos, String yPos, Double ratings, Integer reviews, Integer charge, Integer cleaningFee, Integer serviceFee, Integer taxFee) {
        this.id = id;
        this.location = location;
        this.title = title;
        this.image = image;
        this.description = description;
        this.xPos = xPos;
        this.yPos = yPos;
        this.ratings = ratings;
        this.reviews = reviews;
        this.charge = charge;
        this.cleaningFee = cleaningFee;
        this.serviceFee = serviceFee;
        this.taxFee = taxFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getxPos() {
        return xPos;
    }

    public void setxPos(String xPos) {
        this.xPos = xPos;
    }

    public String getyPos() {
        return yPos;
    }

    public void setyPos(String yPos) {
        this.yPos = yPos;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getCleaningFee() {
        return cleaningFee;
    }

    public void setCleaningFee(Integer cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(Integer taxFee) {
        this.taxFee = taxFee;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", xPos='" + xPos + '\'' +
                ", yPos='" + yPos + '\'' +
                ", ratings=" + ratings +
                ", reviews=" + reviews +
                ", charge=" + charge +
                ", cleaningFee=" + cleaningFee +
                ", serviceFee=" + serviceFee +
                ", taxFee=" + taxFee +
                '}';
    }
}
