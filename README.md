Необходимо	реализовать	REST	сервис	получения	информации	о студентах.		
Состав	объекта	студента:		
1.	Фамилия; 
2.	Имя; 
3.	Отчество; 
4.	Группа; 
5.	Средняя	оценка. 
Приложение	должно:	
1.	Производить	авторизацию	по	протоколу	OAuth2.0	и	возвращать	в ответ	access_token;	
2.	Принимать	запросы	HTTP	GET	на	получения	списка	объектов студентов;	
3.	Принимать	запросы	HTTP	POST	на	изменения	сущности	объекта студента;	
4.	Принимать	запросы	HTTP	PUT	на	добавление	новой	сущности	студента;
5.	Принимать	запросы	HTTP	DELETE	на	удаление	объекта	студента.	
Требования	к	технологиям:	 
-	Java	8	либо	старше	или	Scala; 
-	Play framework или Spring framework; 
-	База	данных	любая.	Предпочтение	отдается	к	mongoDb. 
Исходный	код	выложить	в	git	репозиторий.	
Предоставить	ссылку	на	git	репозиторий	с	инструкцией	по	развертыванию	проекта	и	проектом.	Приложить	примеры	запросов	в	формате	CURL.

Запросы: 
1) Авторизация: curl -X POST \
 -H "Content-Type: application/x-www-form-urlencoded" \
 -d "grant_type=client_credentials&client_id=client&client_secret=secret" \
 "http://localhost:8080/oauth2/token"
2) Получение списка студентов GET:curl -X GET "http://localhost:8080/students"
3) Добавление студента POST: curl -X POST \
 -H "Content-Type: application/json" \
 -d '{"firstName": "Иван", "lastName": "Петров", "age": 20}' \
 "http://localhost:8080/students/registration"
4) Изменение студента PATCH: curl -X PATCH \
 -H "Content-Type: application/json" \
 -d '{"firstName": "Иван", "lastName": "Иванов", "age": 21}' \
 "http://localhost:8080/students/update?id=1"
5) Удаление студента: curl -X DELETE "http://localhost:8080/students/delete?studentId=1"
