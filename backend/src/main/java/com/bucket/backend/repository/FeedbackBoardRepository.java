package com.bucket.backend.repository;

import com.bucket.backend.model.FeedbackBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackBoardRepository extends JpaRepository<FeedbackBoard, Integer> {
}
