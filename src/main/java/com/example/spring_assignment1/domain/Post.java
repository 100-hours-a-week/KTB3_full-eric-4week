package com.example.spring_assignment1.domain;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String title;
    private String content;
    private int likes;
    private int comments;
    private int views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long authorId;
    private String authorNickname;

    public Post(Long id, String title, String content, int likes, int comments, int views, LocalDateTime createdAt, LocalDateTime updatedAt,Long authorId,String authorNickname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.authorId = authorId;
        this.authorNickname = authorNickname;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public int getComments() { return comments; }
    public int getViews() { return views; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Long getAuthorId() { return authorId; }
    public String getAuthorNickname() { return authorNickname; }

    public void setId(Long id) { this.id = id; }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public void increaseViews() {
        this.views++;
    }
    public void increaseComments() {
        this.comments++;
    }
}