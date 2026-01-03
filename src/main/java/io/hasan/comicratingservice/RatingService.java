package io.hasan.comicratingservice;
import io.hasan.comicratingservice.Entities.Rating;
import io.hasan.comicratingservice.Models.ComicRating;
import io.hasan.comicratingservice.Models.UserRatings;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class RatingService {
    // 1. create future variable for Repository bean that will handle db CRUD
     private final RatingRepository ratingRepository;

    // 2. constructor (add Repo in future)
    public RatingService(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    // temporarily hard-coded rating db
    List<Rating> ratings_db = Arrays.asList(
            new Rating("bwayne", "1", 4),
            new Rating("bwayne", "4", 8),
            new Rating("bwayne", "5", 10),
            new Rating("tstark", "2", 4),
            new Rating("tstark", "4", 8),
            new Rating("bbanner", "3", 10));


    public UserRatings getRatings(String userId){
        // 1. get raw list of Ratings
        List<ComicRating> raw_list_of_ratings
                = ratings_db
                .stream() // convert into stream
                .filter(r -> r.getUserId().equals(userId))
                .map(r -> new ComicRating(r.getComicId(), r.getComicRating()))
                .toList();
        // 2. turn into one object: UserRatings
        return new UserRatings(userId, raw_list_of_ratings);
    }

    // add a comic ratings to userId
     public String addRating(String userId, Rating rating){
         ratingRepository.save(rating);
         return "Rating added!";
     }
}
