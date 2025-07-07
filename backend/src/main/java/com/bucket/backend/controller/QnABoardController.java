package com.bucket.backend.controller;


import com.bucket.backend.model.QnABoard;
import com.bucket.backend.repository.QnABoardRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("/api/qna-board")
public class QnABoardController {

    private final QnABoardRepository repository;

    public QnABoardController(QnABoardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<QnABoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PostMapping
    public QnABoard create(@RequestBody QnABoard board) {
        board.setCreatedAt(LocalDateTime.now());
        return repository.save(board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }

}
