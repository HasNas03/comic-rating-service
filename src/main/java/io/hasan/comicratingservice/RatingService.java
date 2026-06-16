package io.hasan.comicratingservice;

import org.springframework.stereotype.Service;
import io.hasan.comicratingservice.models.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class RatingService {

    // 1. create temporary comic database
    // future variable for Repository bean that will handle db CRUD "private final ComicRepository comicRepository;"
    private final Map<UUID, Rating> ratingsDB = new LinkedHashMap<>();

    // 2. Constructor injection of RatingRepository dependency
    public RatingService(){}

    // 3. Declare service methods

    // get list of all ratings
    public List<Rating> getAllRatings() {
        return new ArrayList<>(ratingsDB.values());}

    // get a specific rating by comicId
    public Rating getRatingForComic(UUID comicId) {
        return ratingsDB.values()
                .stream()
                .filter(rating -> rating.getComicId().equals(comicId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));}

    // add a new rating
    public Rating addRating(Rating rating) {
        if (rating.getComicId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "valid comicId is required");}

        validateScore(rating.getRatingScore());

        boolean duplicateExists = ratingsDB.values()
                .stream()
                .anyMatch(existingRating -> existingRating.getComicId().equals(rating.getComicId()));
        if (duplicateExists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Comic already has a rating");}

        rating.setRatingId(UUID.randomUUID());
        ratingsDB.put(rating.getRatingId(), rating);
        return rating;
    }

    // edit an existing rating
    public Rating updateRating(UUID id, Rating ratingUpdate) {
        Rating rating = getRating(id);
        validateScore(ratingUpdate.getRatingScore());

        rating.setRatingScore(ratingUpdate.getRatingScore());
        rating.setRatingReview(ratingUpdate.getRatingReview());
        return rating;}

    // delete an existing rating
    public void deleteRating(UUID id) {
        Rating removedRating = ratingsDB.remove(id);
        if (removedRating == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found");}}

    // --- private helper functions ------------------------------------------------------
    private Rating getRating(UUID id) {
        Rating rating = ratingsDB.get(id);
        if (rating == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found");
        }
        return rating;}

    private void validateScore(int score) {
        if (score < 1 || score > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating score must be between 1 and 10");
        }
    }
}

