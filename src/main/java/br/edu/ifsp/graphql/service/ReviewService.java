package br.edu.ifsp.graphql.service;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;

@Service
public class ReviewService {

    public Review createReview(Episode episode, ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }
}
