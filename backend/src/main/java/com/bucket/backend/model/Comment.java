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
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    private String boardType;
    private int boardId;
    private int uid;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

}
