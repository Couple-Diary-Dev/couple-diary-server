package com.couplediary.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String email;
    private String passwordHash;
    private String nickname;
    private Sex sex;

    @Builder
    public User(String email, String passwordHash, String nickname, Sex sex) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.nickname = nickname;
        this.sex = sex;
    }

    public enum Sex {
        MALE, FEMALE
    }
}
