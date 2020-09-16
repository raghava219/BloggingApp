

HTTP Method : GET 

URL : http://localhost:8080/api/articles

Request Body: Not Applicable

Reponse Body:

[
    {
        "id": 1,
        "title": "How to learn Spring Booot",
        "description": "How to learn Spring Booot",
        "body": "You have to believe",
        "slug": "how-to-learn-spring-boot",
        "createdAt": "2020-07-17T05:55:11.626301",
        "updatedAt": "2020-07-17T05:55:11.626301",
        "numberOfWords": 234
    },
    {
        "id": 2,
        "title": "How to learn Spring MVC",
        "description": "How to learn Spring MVC",
        "body": "You have to believe",
        "slug": "how-to-learn-spring-mvc",
        "createdAt": "2020-07-17T05:55:11.637272",
        "updatedAt": "2020-07-17T05:55:11.637272",
        "numberOfWords": 777
    }
]

Story-1: REST API to create an article
--------------------------------------------------------------

HTTP Method : POST 

URL : http://localhost:8080/api/articles/how-to-learn-spring-cloud

Request Body:

{
    "title": "How to learn Spring cloud",
    "description": "How to learn Spring Cloud",
    "body": "You have to believe Cloud",
    "numberOfWords": 667
}


Reponse Body:

{
    "id": 3,
    "title": "How to learn Spring cloud",
    "description": "How to learn Spring Cloud",
    "body": "You have to believe Cloud",
    "slug": "how-to-learn-spring-cloud",
    "createdAt": "2020-07-17T06:00:31.8479794",
    "updatedAt": "2020-07-17T06:00:31.8479794",
    "numberOfWords": 667
}

Story-2: Update an article
--------------------------------------------------------------


HTTP Method : PUT

URL : http://localhost:8080/api/articles/how-to-learn-spring-cloud

Request Body:

{
    "title": "How to learn Spring Boot by building an app",
    "description": "Ever wonder how?",
    "body": "You have to believe Cloud"
}

Reponse Body:

{
    "id": 3,
    "title": "How to learn Spring Boot by building an app",
    "description": "Ever wonder how?",
    "body": "You have to believe Cloud",
    "slug": "how-to-learn-spring-cloud",
    "createdAt": "2020-07-17T06:06:19.88394",
    "updatedAt": "2020-07-17T06:09:01.1305347",
    "numberOfWords": 667
}

Story-3: Get an article by slug id
--------------------------------------------------------------

HTTP Method : GET

URL : http://localhost:8080/api/articles/how-to-learn-spring-boot

Request Body: Not Applicable

Reponse Body:

{
    "id": 1,
    "title": "How to learn Spring Booot",
    "description": "How to learn Spring Booot",
    "body": "You have to believe",
    "slug": "how-to-learn-spring-boot",
    "createdAt": "2020-07-17T06:06:00.30086",
    "updatedAt": "2020-07-17T06:06:00.30086",
    "numberOfWords": 234
}


Story-4: Delete an article by slug Id
--------------------------------------------------------------

HTTP Method : DELETE

URL : http://localhost:8080/api/articles/how-to-learn-spring-cloud

Request Body: Not Applicable

Reponse Body:

{
    "timestamp": "2020-07-17T00:42:01.886+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Article Deleted",
    "path": "/api/articles/how-to-learn-spring-cloud"
}


Story-5 : Find time to read for an article using its slug id
--------------------------------------------------------------

HTTP Method : GET

URL : http://localhost:8080/api/articles/find-time-to-read/how-to-learn-spring-boot

Request Body: Not Applicable

Reponse Body:

{
    "articleId": "how-to-learn-spring-boot",
    "timeToRead": {
        "mins": 2,
        "seconds": 34.0
    }
}

Following are the REST API Documentation details:
-------------------------------------------------
http://localhost:8080/v2/api-docs

http://localhost:8080/swagger-ui.html





