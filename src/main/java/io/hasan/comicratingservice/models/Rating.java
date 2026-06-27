package io.hasan.comicratingservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;
import java.util.UUID;

@Entity
// no two Rating rows can share the same comicId (enforces one-rating-per-comic rule)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "comicId"))
public class Rating {
    // Rating object parameters
    @Id
    @GeneratedValue
    private UUID ratingId;
    private UUID comicId;
    private int ratingScore;
    @Column(length = 2000)
    private String ratingReview;

    // constructor for Rating object initialization
    public Rating() {}
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