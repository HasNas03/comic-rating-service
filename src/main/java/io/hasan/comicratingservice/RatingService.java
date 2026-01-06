package io.hasan.comicratingservice;
import io.hasan.comicratingservice.Entities.Rating;
import io.hasan.comicratingservice.Models.ComicRating;
import io.hasan.comicratingservice.Models.UserRatings;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

// Service layer containing business logic for comic rating operations
@Service
public class RatingService {

    // Declare Repository for persisting rating data
     private final RatingRepository ratingRepository;

    // Constructor injection of RatingRepository dependency
    public RatingService(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    // temporarily hard-coded rating db (will be replaced by the Repository embedded database)
    List<Rating> ratings_db = Arrays.asList(
            new Rating("bwayne", "1", 4),
            new Rating("bwayne", "4", 8),
            new Rating("bwayne", "5", 10),
            new Rating("tstark", "2", 4),
            new Rating("tstark", "4", 8),
            new Rating("bbanner", "3", 10));

    // get ALL ratings of a user
    public UserRatings getRatings(String userId){
        // 1. get the raw list of Ratings
        List<ComicRating> raw_list_of_ratings
                = ratings_db
                .stream() // convert into stream
                .filter(r -> r.getUserId().equals(userId))
                .map(r -> new ComicRating(r.getComicId(), r.getComicRating()))
                .toList();
        // 2. turn into one object: UserRatings
        return new UserRatings(userId, raw_list_of_ratings);
    }

    // get a specific rating
    // public UserRatings getRating(String userId, String comicId){
        // 1. get raw list of Ratings
    //     List<ComicRating> raw_list_of_rating
    //             = ratings_db
    //             .stream() // convert into stream
    //             .filter(r -> r.getUserId().equals(userId))
    //             .filter(r -> r.getComicId().equals(comicId))
    //             .map(r -> new ComicRating(r.getComicId(), r.getComicRating()))
    //             .toList();
        // 2. turn into one object: UserRatings
    //     return new UserRatings(userId, raw_list_of_rating);
    // }

    // add a comic ratings to userId
    // public String addRating(String userId, Rating rating){
    //     ratingRepository.save(rating);
    //     return "Rating added!";
    // }
}
