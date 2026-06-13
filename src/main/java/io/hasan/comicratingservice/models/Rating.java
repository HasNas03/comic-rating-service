package io.hasan.comicratingservice.models;
import java.util.UUID;

public class Rating {

    // Rating object parameters
    private UUID ratingId;
    private UUID comicId;
    private int ratingScore;
    private String ratingReview;

    // constructor for Rating object initialization
    public Rating(UUID comicId, int ratingScore, String ratingReview) {
        this.comicId = comicId;
        this.ratingScore = ratingScore;
        this.ratingReview = ratingReview;
    }

    // getters and setters
    public UUID getRatingId() {return ratingId;}
    public void setRatingId(UUID ratingId) {this.ratingId = ratingId;}
    public UUID getComicId() {return comicId;}
    public void setComicId(UUID comicId) {this.comicId = comicId;}
    public int getRatingScore() {return ratingScore;}
    public void setRatingScore(int ratingScore) {this.ratingScore = ratingScore;}
    public String getRatingReview() {return ratingReview;}
    public void setRatingReview(String ratingReview) {this.ratingReview = ratingReview;}
}