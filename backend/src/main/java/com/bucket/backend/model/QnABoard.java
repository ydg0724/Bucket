package com.bucket.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class QnABoard {
    @Id
    @GeneratedValue
    private int id;

    private int uid;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createAt;
}
