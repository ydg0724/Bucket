package com.bucket.backend.controller;


import com.bucket.backend.model.Comment;
import com.bucket.backend.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository commentRepository) {
        this.repository = commentRepository;
    }

    @GetMapping("/{boardType}/{boardId}")
    public List<Comment> getComments(@PathVariable("boardType") String boardType,@PathVariable int boardId) {
        return repository.findByBoardTypeAndBoardIdOrderByCreatedAtAsc(boardType, boardId);
    }

    @PostMapping("/{boardType}/{boardId}")
    public Comment addComment(@PathVariable("boardType") String boardType,@PathVariable int boardId, @RequestBody Comment comment) {
        comment.setBoardType(boardType);
        comment.setBoardId(boardId);
        comment.setCreatedAt(LocalDateTime.now());
        return repository.save(comment);
    }
}
