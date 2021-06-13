package com.imadelfetouh.profileservice.model.dto;

import com.imadelfetouh.profileservice.model.datetime.DateTime;

public class TweetDTO {

    private String tweetId;
    private String content;
    private String date;
    private String time;
    private int likes;
    private boolean userLiked;

    public TweetDTO() {

    }

    public TweetDTO(String tweetId, String content, Long date, String time, int likes, boolean userLiked) {
        this.tweetId = tweetId;
        this.content = content;
        this.date = DateTime.getInstance().timeStampToString(date);
        this.time = time;
        this.likes = likes;
        this.userLiked = userLiked;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public void setUserLiked(boolean userLiked) {
        this.userLiked = userLiked;
    }

    public boolean isUserLiked() {
        return userLiked;
    }
}
