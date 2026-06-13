package io.hasan.comicratingservice;

import io.hasan.comicratingservice.models.Rating;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/ratings")
public class RatingController {

    // 1. create variable for Service bean that will handle logic
    private final RatingService ratingService;

    // 2. constructor injection of RatingService dependency
    public RatingController(RatingService ratingService) {this.ratingService = ratingService;}

    // 3. write API for HTTP methods:

    // get all ratings
    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();}

    // get a specific rating by comicId
    @GetMapping("/{comicId}")
    public Rating getRatingForComic(@PathVariable UUID comicId) {
        return ratingService.getRatingForComic(comicId);}

    // add a new rating
    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);}

    // edit an existing rating
    @PutMapping("/{ratingId}")
    public Rating updateRating(@PathVariable UUID ratingId, @RequestBody Rating rating) {
        return ratingService.updateRating(ratingId, rating);}

    // delete an existing rating
    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable UUID ratingId) {
        ratingService.deleteRating(ratingId);
    }







    // GET /ratings/{userId} - get ALL ratings of a user
//    @RequestMapping(method= RequestMethod.GET, value="/{userId}")
//    public UserRatings getRatings(@PathVariable("userId") String userId){
//        return ratingService.getRatings(userId);
//    }

    // GET /ratings/{userId}/{comicId} - get A rating of a specific comic from a user
    // @RequestMapping(method= RequestMethod.GET, value="/{userId}/{comicId}")
    // public UserRatings getRating(@PathVariable("userId") String userId,
    //                              @PathVariable("comicId") String comicId){
    //     return ratingService.getRating(userId, comicId);
    // }

    // ADD /ratings/{userId} - add a rating
    // @RequestMapping(method= RequestMethod.POST, value="/{userId}")
    // public String getRatings(@PathVariable("userId") String userId, @RequestBody Rating rating){
    //     return ratingService.addRating(userId, rating);
    // }
}
