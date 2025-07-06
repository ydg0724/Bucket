package com.bucket.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class QnABoard {
    @Id
    @GeneratedValue
    private int id;

    private String userId;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createAt;
}
