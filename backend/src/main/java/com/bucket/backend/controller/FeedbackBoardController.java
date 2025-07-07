package com.bucket.backend.controller;


import com.bucket.backend.model.FeedbackBoard;
import com.bucket.backend.repository.FeedbackBoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/feedback-board")
public class FeedbackBoardController {

    private final FeedbackBoardRepository repository;

    public FeedbackBoardController(FeedbackBoardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FeedbackBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PostMapping FeedbackBoard create(@RequestBody FeedbackBoard board) {
        board.setCreatedAt(LocalDateTime.now());
        return repository.save(board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
