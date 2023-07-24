package com.br.songbox.controllers;

import com.br.songbox.models.ReviewModel;
import com.br.songbox.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewModel> post(@Valid @RequestBody ReviewModel reviewModel) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reviewService.save(reviewModel));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReviewModel> get(@PathVariable UUID id) {
        return ResponseEntity
                .status(200)
                .body(reviewService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ReviewModel>> get() {
        return ResponseEntity
                .status(200)
                .body(reviewService.getAll());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ReviewModel> delete(@PathVariable UUID id) {
        reviewService.deleteById(id);
        return ResponseEntity
                .status(200)
                .build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ReviewModel> put(@PathVariable UUID id, @Valid @RequestBody ReviewModel reviewModel) {
        return ResponseEntity
                .status(200)
                .body(reviewService.update(id, reviewModel));
    }
}
