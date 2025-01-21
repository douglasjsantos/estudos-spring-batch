package com.example.demo.dto;

import java.time.Instant;

public class UserDTO {

    private Long id;
    private String login;
    private String name;
    private String location;
    private String avatarUrl;
    private Integer followers;
    private Integer following;
    private Instant createdAt;
    private String reposUrl;
    private String company;

    public UserDTO(){

    }

    public UserDTO(Long id, String login, String name, String location, String avatarUrl, Integer followers, Integer following, Instant createdAt, String reposUrl, String company) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.location = location;
        this.avatarUrl = avatarUrl;
        this.followers = followers;
        this.following = following;
        this.createdAt = createdAt;
        this.reposUrl = reposUrl;
        this.company = company;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", createdAt=" + createdAt +
                ", reposUrl='" + reposUrl + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
