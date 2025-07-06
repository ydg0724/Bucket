package com.bucket.backend.repository;

import com.bucket.backend.model.QnABoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnABoardRepository extends JpaRepository<QnABoard, Integer> {
}
