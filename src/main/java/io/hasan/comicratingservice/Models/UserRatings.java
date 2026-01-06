package io.hasan.comicratingservice.Models;
import java.util.List;

// DTO wrapping a user's ID with their list of comic ratings (ComicRating objects)
public class UserRatings {

    // attributes
    String user_id;
    List<ComicRating> user_ratings;

    // constructors
    public UserRatings(){};
    public UserRatings(String user_id, List<ComicRating> user_ratings) {
        this.user_id = user_id;
        this.user_ratings = user_ratings;
    }

    // getters and setters
    public String getUser_id() {return user_id;}
    public void setUser_id(String user_id) {this.user_id = user_id;}
    public List<ComicRating> getUser_ratings() {return user_ratings;}
    public void setUser_ratings(List<ComicRating> user_ratings) {this.user_ratings = user_ratings;}
}
