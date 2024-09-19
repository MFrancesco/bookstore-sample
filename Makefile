run:
	./mvnw spring-boot:run

docker-build:
	./mvnw package
	docker build -t frehub/bookstore:latest .

docker-push:
	docker push frehub/bookstore:latest

docker-run:
	echo "Will run the app locally, then you could visit http://localhost:8081/swagger-ui/index.html"
	docker run -p 8081:8080 frehub/bookstore:latest
