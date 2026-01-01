package io.hasan.comicratingservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    // 1. create variable for Service bean that will handle logic
    private final RatingService ratingService;

    // 2. constructor
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;}

    // 3. write API of HTTP methods:

    // GET /ratings/{userId} - get all ratings of a user
    @RequestMapping(method= RequestMethod.GET, value="/{userId}")
    public List<Rating> getRatings(@PathVariable("userId") String userId){
        // create a temporary hard-coded list of ratings
        // in reality you must search Rating's for matching 'userId'
        return ratingService.getRatings(userId);
    }

    // ADD /ratings/{userId} - add a rating
    // @RequestMapping(method= RequestMethod.POST, value="/{userId}")
    // public String getRatings(@PathVariable("userId") String userId, @RequestBody Rating rating){
    //     return ratingService.addRating(userId, rating);
    // }
}
