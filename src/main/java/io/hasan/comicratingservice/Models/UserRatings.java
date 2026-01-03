package io.hasan.comicratingservice.Models;
import io.hasan.comicratingservice.Entities.Rating;

import java.util.List;

// Response wrapper class
public class UserRatings {
    String user_id;
    List<ComicRating> user_ratings;

    public UserRatings(){};
    public UserRatings(String user_id, List<ComicRating> user_ratings) {
        this.user_id = user_id;
        this.user_ratings = user_ratings;
    }

    public String getUser_id() {return user_id;}
    public void setUser_id(String user_id) {this.user_id = user_id;}
    public List<ComicRating> getUser_ratings() {return user_ratings;}
    public void setUser_ratings(List<ComicRating> user_ratings) {this.user_ratings = user_ratings;}
}
