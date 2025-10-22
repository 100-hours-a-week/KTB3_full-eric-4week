package com.example.spring_assignment1.domain;

import lombok.Builder;

@Builder(toBuilder = true)
public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profile_image;

    public User(Long id, String email, String password, String nickname, String profile_image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profile_image = profile_image;
    }

    public User initId(Long id){
        return this.toBuilder().id(id).build();
    }
    public User updateNickname(String nickname){
        return this.toBuilder().nickname(nickname).build();
    }
    /* setter 방식(값을 직접 바꿈)
    public User updateNickname(String nickname){
        this.nickname = nickname;
    }
     */
    public User updatePassword(String password){
        return this.toBuilder().password(password).build();
    }

    public boolean validatePassword(String currentPassword) {
        return password.equals(currentPassword);
    }

    public Long getId() {return id;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getNickname() {return nickname;}
    public String getProfile_image() {return profile_image;}
    //public void setId(Long id) {this.id = id;}
    //public void setNickname(String nickname) {this.nickname = nickname;}
    //public void setPassword(String password) {this.password = password;}
}
