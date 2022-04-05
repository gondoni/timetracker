docker build -t tt-mysql --no-cache .
docker run --name timetracker-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=gondoni-pwd -d tt-mysql