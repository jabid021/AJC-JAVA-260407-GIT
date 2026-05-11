# Eventuellement
./mvnw clean package -DskipTests

docker build -t ajc/quest:back .

docker run -d --name quest-mysql --network quest -v D:/ajc/projet_quest.sql:/docker-entrypoint-initdb.d/init.sql -e MYSQL_ROOT_PASSWORD=root mysql:8.0.45

docker run --rm -it --network quest -e JDBC_URL=jdbc:mysql://quest-mysql:3306/projet_quest ajc/quest:back
