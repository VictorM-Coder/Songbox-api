package com.br.songbox.services;

import com.br.songbox.models.ReviewModel;
import com.br.songbox.repositories.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewModel save(ReviewModel reviewModel){
        return reviewRepository.save(reviewModel);
    }

    public ReviewModel getById(UUID id) {
        return reviewRepository.getReferenceById(id);
    }

    public List<ReviewModel> getAll() {
        return reviewRepository.findAll();
    }

    public void deleteById(UUID id) {
        reviewRepository.deleteById(id);
    }

    public ReviewModel update(UUID id, ReviewModel reviewModel) {
        ReviewModel reviewFounded = getById(id);
        BeanUtils.copyProperties(reviewModel, reviewFounded);
        return reviewRepository.save(reviewFounded);
    }
}
