package com.couplediary.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
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

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void updateSex(Sex sex) {
        this.sex = sex;
    }
}
