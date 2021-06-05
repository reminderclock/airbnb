package com.codesquad.team10.airbnb.model;

import org.springframework.data.annotation.Id;

public class Reserve {
    @Id
    private Long id;

    private String userId;
    private Long roomId;
    private String checkIn;
    private String checkOut;
    private Integer guests;

    public Reserve() {
    }

    public Reserve(Long id, String userId, Long roomId, String checkIn, String checkOut, Integer guests) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", roomId=" + roomId +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", guests=" + guests +
                '}';
    }
}
