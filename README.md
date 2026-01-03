**Comic Catalog Project**

- The Comic Catalog is a personal-use project aiming to develop a custom application for storing comic book reviews and reading progress


- This is a list of repositories for all microservices used in this project
    - [Comic Catalog Microservice (primary client-facing API)](https://github.com/HasNas03/comic-catalog-service)
    - [Comic Info Service Microservice](https://github.com/HasNas03/comic-info-service)
    - [Comic Rating Microservice](https://github.com/HasNas03/comic-rating-service)


- The project is also a gateway for me to learn and practice:
    - backend development (Java & Spring)
    - best practices
    - developing REST APIs
    - connecting to external APIs
    - cross-microservice creation/integration
    - testing and security
    - external database integration
    - Cloud integration/hosting

- Technologies
    - Current technologies: Java, Spring (Boot, Web, JPA), Maven, Git
    - Future technologies: (SQL/MongoDB), Docker, AWS, Spring Security
---

---
**Comic Rating Microservice**

- A primary feature of the application is the ability for a user to store ratings (1-10) of comic runs read (not individual issues but rather broader events)
- The Comic Rating API provides REST endpoints for the Comic Catalog Microservice to interact with the Rating database


- Architecture (suggestions/improvements are welcome/encouraged!):
  - **Rating (Entity)**
    - Rating(String userId, String comicId, int comicRating)
    - JPA entity representing a stored rating record, including the rater (userId), the target comic (comicId), and the numeric score (comicRating)

  - **ComicRating (Model)**
    - ComicRating(String id, Integer rating)
    - Lightweight DTO used in API responses to expose only the comic identifier (id) and the rating value (rating) (i.e., omits repeated userId per item in the response)

  - **UserRatings (Model)**
    - UserRatings(String user_id, List<ComicRating> user_ratings)
    - Response wrapper DTO for user-scoped endpoints: returns the user_id once and a list of that user’s ComicRating entries

  - **RatingController**
    - REST controller for the Ratings microservice (/ratings)

  - **RatingService**
    - Service layer containing the business logic

  - **RatingRepository**
    - Spring Data repository interface (CrudRepository) for performing CRUD operations on Rating entities (abstracts away the database access layer)
