package com.couplediary.couple.domain;

import com.couplediary.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "couples")
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    @OneToOne
    private User user2;

    private String name;
    private LocalDate anniversary;

    @Builder
    public Couple(User user1, User user2) {
        this.user = user1;
        this.user2 = user2;
    }
}
