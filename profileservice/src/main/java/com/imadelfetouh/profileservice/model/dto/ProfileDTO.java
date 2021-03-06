package com.imadelfetouh.profileservice.model.dto;

import java.util.List;

public class ProfileDTO {

    private String userId;
    private String username;
    private String photo;
    private String bio;
    private String location;
    private String website;
    private Long following;
    private Long followers;
    private Integer follow;
    private List<TweetDTO> tweets;

    public ProfileDTO() {

    }

    public ProfileDTO(String userId, String username, String photo, String bio, String location, String website, Long following, Long followers, Integer follow) {
        this.userId = userId;
        this.username = username;
        this.photo = photo;
        this.bio = bio;
        this.location = location;
        this.website = website;
        this.following = following;
        this.followers = followers;
        this.follow = follow;
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

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setTweets(List<TweetDTO> tweets) {
        this.tweets = tweets;
    }

    public List<TweetDTO> getTweets() {
        return tweets;
    }
}
