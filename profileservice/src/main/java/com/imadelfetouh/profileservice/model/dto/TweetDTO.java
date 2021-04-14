package com.imadelfetouh.profileservice.model.dto;

public class TweetDTO {

    private String tweetId;
    private String content;
    private Long date;
    private String time;
    private int likes;

    public TweetDTO() {

    }

    public TweetDTO(String tweetId, String content, Long date, String time, int likes) {
        this.tweetId = tweetId;
        this.content = content;
        this.date = date;
        this.time = time;
        this.likes = likes;
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

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getDate() {
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
}
