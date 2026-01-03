package io.hasan.comicratingservice;

import io.hasan.comicratingservice.Entities.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, String> {
}
