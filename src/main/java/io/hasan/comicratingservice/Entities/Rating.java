package io.hasan.comicratingservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// primary Rating entity used to store comic rating data
@Entity
public class Rating {

    // attributes
    @Id
    private String userId;
    // *: potential type and purpose change for comicId: going from numbered ID to unique run title
    private String comicId;
    private int comicRating;

    // constructors
    public Rating() {}
    public Rating(String userId, String comicId, int comicRating) {
        this.userId = userId;
        this.comicId = comicId;
        this.comicRating = comicRating;
    }

    // getters and setters
    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}
    public String getComicId() {return comicId;}
    public void setComicId(String comicId) {this.comicId = comicId;}
    public int getComicRating() {return comicRating;}
    public void setComicRating(int comicRating) {this.comicRating = comicRating;}
}
