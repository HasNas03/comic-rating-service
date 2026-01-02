package io.hasan.comicratingservice;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingService {
    // 1. create future variable for Repository bean that will handle db CRUD
    // private final RatingRepository ratingRepository;

    // 2. constructor
    public RatingService(){}

    // get all ratings by userId
    public List<Rating> getRatings(String userId){
        // temporarily hard-coded rating db
        List<Rating> user_ratings = Arrays.asList(
                new Rating("bwayne", "1", 4),
                new Rating("bwayne", "4", 8),
                new Rating("bwayne", "5", 10),
                new Rating("tstark", "2", 4),
                new Rating("tstark", "4", 8),
                new Rating("bbanner", "3", 10));

        // get ratings for only userId
        List<Rating> user_rating = user_ratings
                .stream() // convert into stream
                .filter(r -> r.getUserId().equals(userId))
                .toList();
        return user_rating;
    }

    // add a comic ratings to userId
    // public String addRating(String userId, Rating rating){
        // insert code to add rating to db
    //     return "Rating added!";
    // }
}
