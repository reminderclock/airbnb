package com.codesquad.team10.airbnb.model;

import org.springframework.data.annotation.Id;

public class WishList {
    @Id
    private Long id;

    private String userId;
    private Long roomId;

    public WishList() {
    }

    public WishList(Long id, String userId, Long roomId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
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

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
