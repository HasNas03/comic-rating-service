package io.hasan.comicratingservice;

import io.hasan.comicratingservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID> {
    Optional<Rating> findByComicId(UUID comicId);
    boolean existsByComicId(UUID comicId);
}