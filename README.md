## Comic Catalog Project

- The Comic Catalog is a personal-use project aiming to develop a custom application for storing comic book reviews and reading progress


- This is a list of repositories for all microservices/servers used in this project
    - [Comic Catalog Microservice (primary client-facing API)](https://github.com/HasNas03/comic-catalog-service)
    - [Comic Info Service Microservice](https://github.com/HasNas03/comic-info-service)
    - [Comic Rating Microservice](https://github.com/HasNas03/comic-rating-service)
    - [Comic Catalog Discovery Server](https://github.com/HasNas03/discovery-server)


- The project is also a gateway for me to learn and practice:
    - backend development (Java & Spring) best practices
    - developing REST APIs
    - connecting to external APIs
    - cross-microservice integration/authentication
    - testing and security
    - external database integration
    - Cloud integration/hosting

- Technologies
    - Current technologies: Java, Spring (Boot, Web), Netflix Eureka, Maven, Git
    - Future technologies: (SQL/MongoDB), Docker, AWS, Spring Security
---

---
## Comic Rating Microservice

- A primary feature of the application is the ability for a user to store ratings (1-10) of individual issues
- The Comic Rating API provides REST endpoints for the Comic Catalog Microservice to interact with the Rating database


### Model
`Rating`
- `UUID id`
- `UUID comicId`
- `int score`
- `String reviewText`

## Endpoints
```text
GET    /ratings
GET    /ratings/comics/{comicId}
POST   /ratings
PUT    /ratings/{id}
DELETE /ratings/{id}