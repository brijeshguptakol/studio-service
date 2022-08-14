# studio-service
Studio service contains different APIs for creating classes and booking a class for a particular date.

# Contents
   1. [API](#api)
   2. [How to run it locally](#how-to-run-it-locally)
   
## API
Classes
```
POST /v1/classes - To create a class with bare minimum information 
GET /v1/classes/{id} - To get details of a class by id of the class
```

Bookings
```
POST /v1/bookings - To make a booking for a particular class on a particular date.
GET /v1/bookings/{id} - To get details of a booking by booking id.
```

#how-to-run-it-locally
To run the application, we need Java 17 and an IDE (say InteliJ Idea)
To run locally, just run the (StudioApplication)[https://github.com/brijeshguptakol/studio-service/blob/70b549dd100377473b3b4b7b2b431de7f80a7c5f/src/main/java/com/brijesh/studio/StudioApplication.java#L9]
