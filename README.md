# Event Management API

This is a Spring Boot application that provides APIs to manage events, venues, categories, and event attendees.

## Features

- Manage categories of events.
- Manage venues where events are hosted.
- Manage events and their details.
- Manage attendees for events.

## API Endpoints

### Home Page API
- **GET** `/home`  
  Retrieves the home page.

---

### Category API

- **GET** `/api/category/allcategory`  
  Retrieves all categories.

- **GET** `/api/category/getcategory/{id}`  
  Retrieves a specific category by its ID.

- **POST** `/api/category/createcategory`  
  Creates a new category.  
  **Request Body (example):**
  ```json
  {
      "category_name": ""
  }
  ```

- **DELETE** `/api/category/deletecategory/{id}`  
  Deletes a category by its ID.

---

### Venue API

- **GET** `/api/venue/getallvenue`  
  Retrieves all venues.

- **GET** `/api/venue/getvenue/{id}`  
  Retrieves a specific venue by its ID.

- **POST** `/api/venue/createvenue`  
  Creates a new venue.  
  **Request Body (example):**
  ```json
  {
      "name": "",
      "location": ""
  }
  ```

- **DELETE** `/api/venue/deletevenue/{id}`  
  Deletes a venue by its ID.

---

### Events API

- **GET** `/api/events/getallevent`  
  Retrieves all events.

- **GET** `/api/events/getevent/{id}`  
  Retrieves a specific event by its ID.

- **POST** `/api/events/addevent`  
  Creates a new event.  
  **Request Body (example):**
  ```json
  {
      "eventTitle": "",
      "dateTime": "",
      "venue": {
          "venue_id": 1
      },
      "category": {
          "category_id": 1
      }
  }
  ```

- **PUT** `/api/events/updateevent/{id}`  
  Updates an existing event by its ID.

- **DELETE** `/api/events/deleteevent/{id}`  
  Deletes an event by its ID.

---

### Event-Attendee API

- **GET** `/api/attendees/getallattendees`  
  Retrieves all event attendees.

- **GET** `/api/attendees/getattendee/{id}`  
  Retrieves a specific attendee by their ID.

- **POST** `/api/attendees/addattendee/{eventId}`  
  Adds a new attendee to an event.  
  **Request Body (example):**
  ```json
  {
      "name": "",
      "email": ""
  }
  ```

- **DELETE** `/api/attendees/deleteattendee/{id}`  
  Deletes an attendee by their ID.

---

## How to Run the Project

1. Clone the repository:  
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:  
   ```bash
   cd <project-directory>
   ```
3. Build the project using Maven:  
   ```bash
   mvn clean install
   ```
4. Run the application:  
   ```bash
   mvn spring-boot:run
   ```
5. The application will be running at:  
   `http://localhost:8080`

---

## Testing the API using Postman

1. **Home Page API Call:**
   - **Method**: GET  
   - **URL**: `localhost:8080/home`  
   - **Expected Response**:  
     ```json
     {
         "message": "Welcome to the Home Page"
     }
     ```

2. **Category API Calls**:
   - **Get All Categories**  
     **Method**: GET  
     **URL**: `localhost:8080/api/category/allcategory`

   - **Get Category by ID**  
     **Method**: GET  
     **URL**: `localhost:8080/api/category/getcategory/1`

   - **Create Category**  
     **Method**: POST  
     **URL**: `localhost:8080/api/category/createcategory`  
     **Body (JSON)**:  
     ```json
     {
         "category_name": ""
     }
     ```

   - **Delete Category**  
     **Method**: DELETE  
     **URL**: `localhost:8080/api/category/deletecategory/1`

3. **Venue API Calls**:
   - **Get All Venues**  
     **Method**: GET  
     **URL**: `localhost:8080/api/venue/getallvenue`

   - **Get Venue by ID**  
     **Method**: GET  
     **URL**: `localhost:8080/api/venue/getvenue/1`

   - **Create Venue**  
     **Method**: POST  
     **URL**: `localhost:8080/api/venue/createvenue`  
     **Body (JSON)**:  
     ```json
     {
         "name": "",
         "location": ""
     }
     ```

   - **Delete Venue**  
     **Method**: DELETE  
     **URL**: `localhost:8080/api/venue/deletevenue/1`

4. **Event API Calls**:
   - **Get All Events**  
     **Method**: GET  
     **URL**: `localhost:8080/api/events/getallevent`

   - **Get Event by ID**  
     **Method**: GET  
     **URL**: `localhost:8080/api/events/getevent/1`

   - **Create Event**  
     **Method**: POST  
     **URL**: `localhost:8080/api/events/addevent`  
     **Body (JSON)**:  
     ```json
     {
         "eventTitle": "",
         "dateTime": "",
         "venue": {
             "venue_id": 1
         },
         "category": {
             "category_id": 1
         }
     }
     ```

   - **Update Event**  
     **Method**: PUT  
     **URL**: `localhost:8080/api/events/updateevent/1`  
     **Body (JSON)**:  
     ```json
     {
         "eventTitle": "",
         "dateTime": ""
     }
     ```

   - **Delete Event**  
     **Method**: DELETE  
     **URL**: `localhost:8080/api/events/deleteevent/1`

5. **Event-Attendee API Calls**:
   - **Get All Attendees**  
     **Method**: GET  
     **URL**: `localhost:8080/api/attendees/getallattendees`

   - **Get Attendee by ID**  
     **Method**: GET  
     **URL**: `localhost:8080/api/attendees/getattendee/1`

   - **Add Attendee to an Event**  
     **Method**: POST  
     **URL**: `localhost:8080/api/attendees/addattendee/1`  
     **Body (JSON)**:  
     ```json
     {
         "name": "",
         "email": ""
     }
     ```

   - **Delete Attendee**  
     **Method**: DELETE  
     **URL**: `localhost:8080/api/attendees/deleteattendee/1`

---

## Tools and Technologies

- **Spring Boot**
- **Maven**
- **Postman** (for API testing)

---

Let me know if you need more adjustments or additional sections!
