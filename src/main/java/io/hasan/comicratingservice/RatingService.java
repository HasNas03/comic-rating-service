package io.hasan.comicratingservice;

import org.springframework.stereotype.Service;
import io.hasan.comicratingservice.models.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    // 1. Repository bean that will handle db CRUD
    private final RatingRepository ratingRepository;
    private static final int MAX_REVIEW_LENGTH = 2000;

    // 2. Constructor injection of RatingRepository dependency
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;}

    // 3. Declare service methods

    // get list of all ratings
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();}

    // get a specific rating by comicId
    public Rating getRatingForComic(UUID comicId) {
        return ratingRepository
                .findByComicId(comicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));}

    // add a new rating
    public Rating addRating(Rating rating) {
        if (rating.getComicId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "valid comicId is required");}
        validateScore(rating.getRatingScore());
        validateReview(rating.getRatingReview());

        if (ratingRepository.existsByComicId(rating.getComicId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Comic already has a rating");}

        // set any previous id to null
        rating.setRatingId(null);
        return ratingRepository.save(rating);
    }

    // edit an existing rating
    public Rating updateRating(UUID id, Rating ratingUpdate) {
        Rating rating = getRating(id);
        validateScore(ratingUpdate.getRatingScore());
        validateReview(rating.getRatingReview());

        rating.setRatingScore(ratingUpdate.getRatingScore());
        rating.setRatingReview(ratingUpdate.getRatingReview());
        return ratingRepository.save(rating);}

    // delete an existing rating
    public void deleteRating(UUID id) {
        ratingRepository.delete(getRating(id));}

    // --- private helper functions ------------------------------------------------------
    private Rating getRating(UUID id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));}

    private void validateScore(int score) {
        if (score < 1 || score > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating score must be between 1 and 10");
        }}

    private void validateReview(String review) {
        if (review != null && review.length() > MAX_REVIEW_LENGTH) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Review must be 2000 characters or fewer");
        }
    }
}