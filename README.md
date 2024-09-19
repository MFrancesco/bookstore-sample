## Bookstore demo

Spring 3 Java 21 bookstore demo project



1. The application needs an API to retrieve a list of books with quantity in stock below a
   specified threshold (e.g. all books that have quantity in stock lower than 5).
2. The application needs an API to get a list of the top 'N' selling authors (user provides
   'N'), ranked by the total number of books sold


## How to run

### Build it by yourself (skdman needed)

- `./prepare_env.sh`
- `./mvnw spring-boot:run`


### Running the docker public image

`docker run -p 8081:8080 frehub/bookstore:latest`