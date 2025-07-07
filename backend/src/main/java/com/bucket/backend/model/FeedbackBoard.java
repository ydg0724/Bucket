package com.bucket.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//본인 운동영상에 대한 피드백을 공유할 수 있는 게시판
@Entity
@Getter
@Setter
public class FeedbackBoard {
    @Id
    @GeneratedValue
    private int id;

    private String userId;
    private String exerciseType;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String videoUrl;
    private LocalDateTime createdAt;
}


