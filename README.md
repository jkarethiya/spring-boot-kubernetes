kubectl config use-context docker-desktop


https://spring.io/guides/gs/spring-boot-docker
https://spring.io/guides/gs/spring-boot-kubernetes


mvnw clean package

set SPRING_PROFILES_ACTIVE=local
java -jar target\spring-boot-kubernetes-0.0.1-SNAPSHOT.jar

mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=jkarethiya/spring-boot-kubernetes

docker run --name spring-boot-kubernetes -e "SPRING_PROFILES_ACTIVE=local" -p 9080:9080 -t jkarethiya/spring-boot-kubernetes

docker push docker.io/jkarethiya/spring-boot-kubernetes:latest
 
docker stop 9cf9faa1424f82f8671d3423e58c227232f6cb1ee17e38c7f11f371822055e07 && docker rm -f 9cf9faa1424f82f8671d3423e58c227232f6cb1ee17e38c7f11f371822055e07

 
kubectl create deployment spring-boot-kubernetes --image=jkarethiya/spring-boot-kubernetes --dry-run=client -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip spring-boot-kubernetes --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml


kubectl apply -f deployment.yaml
kubectl delete deploy spring-boot-kubernetes

kubectl port-forward svc/spring-boot-kubernetes 8080:8080
