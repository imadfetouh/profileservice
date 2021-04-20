package com.imadelfetouh.profileservice.model.dto;

import java.io.Serializable;

public class NewUserDTO implements Serializable {

    private String userId;
    private String username;
    private String photo;
    private NewProfileDTO profile;

    public NewUserDTO(String userId, String username, String photo, NewProfileDTO profile) {
        this.userId = userId;
        this.username = username;
        this.photo = photo;
        this.profile = profile;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setProfile(NewProfileDTO profile) {
        this.profile = profile;
    }

    public NewProfileDTO getProfile() {
        return profile;
    }
}
