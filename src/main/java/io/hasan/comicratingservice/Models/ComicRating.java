package io.hasan.comicratingservice.Models;

// DTO for transferring comic rating data without repetitive userId
public class ComicRating {

    // attributes
    String comicId;
    Integer comicRating;

    // constructor
    public ComicRating(String comicId, Integer comicRating) {
        this.comicId = comicId;
        this.comicRating = comicRating;
    }

    // getters and setters
    public String getComicId() {return comicId;}
    public void setComicId(String comicId) {this.comicId = comicId;}
    public Integer getComicRating() {return comicRating;}
    public void setComicRating(Integer comicRating) {this.comicRating = comicRating;}
}
