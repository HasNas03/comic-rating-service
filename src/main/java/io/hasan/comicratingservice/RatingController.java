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
        return ratingService.getRatings(userId);
    }

    // GET /ratings/{userId}/{comicId} - get A rating of a specific comic from a user
    // @RequestMapping(method= RequestMethod.GET, value="/{userId}/{comicId}")
    // public UserRatings getRating(@PathVariable("userId") String userId,
    //                              @PathVariable("comicId") String comicId){
    //     return ratingService.getRating(userId, comicId);
    // }

    // ADD /ratings/{userId} - add a rating
     @RequestMapping(method= RequestMethod.POST, value="/{userId}")
     public String getRatings(@PathVariable("userId") String userId, @RequestBody Rating rating){
         return ratingService.addRating(userId, rating);
     }
}
