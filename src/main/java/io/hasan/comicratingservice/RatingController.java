package io.hasan.comicratingservice;
import io.hasan.comicratingservice.Entities.Rating;
import io.hasan.comicratingservice.Models.UserRatings;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    // 1. create variable for Service bean that will handle logic
    private final RatingService ratingService;

    // 2. constructor
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;}

    // 3. write API of HTTP methods:

    // GET /ratings/{userId} - get ALL ratings of a user
    @RequestMapping(method= RequestMethod.GET, value="/{userId}")
    public UserRatings getRatings(@PathVariable("userId") String userId){
        UserRatings to_send = ratingService.getRatings(userId);
        return to_send;
    }

    // GET ??? - get A rating of a specific comic from a user

    // ADD /ratings/{userId} - add a rating
     @RequestMapping(method= RequestMethod.POST, value="/{userId}")
     public String getRatings(@PathVariable("userId") String userId, @RequestBody Rating rating){
         return ratingService.addRating(userId, rating);
     }
}
