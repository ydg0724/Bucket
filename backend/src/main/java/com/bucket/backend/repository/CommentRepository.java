package com.bucket.backend.repository;

import com.bucket.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBoardTypeAndBoardIdOrderByCreatedAtAsc(String boardType, int boardId);
}
