package com.example.spring_assignment1.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
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

    public Post initId(Long id){
        return this.toBuilder().id(id).build();
    }
    public Post updatePost(String title, String content) {
        return this.toBuilder().title(title).content(content).updatedAt(LocalDateTime.now()).build();
    }

    public void increaseViews() {
        this.views++;
    }
    public void increaseComments() {
        this.comments++;
    }
}