<h1 align="center">MAVA (Medical Astronaut Vital Assistant)</h1>

<p align="center">
  <img src="https://github.com/kyrollos2/M.A.V.A/blob/main/Project_M.A.V.a_2.gif" alt="Project Banner">
</p>

<h4 align="center">🚀 Revolutionizing Health Assessment for Astronauts 🌌</h4>


---

## 📖 Table of Contents

- [Overview](#-overview)

- [Tech Stack](#-tech-stack)
  - [Front-End Development](#front-end-development)
  - [Back-End Development](#back-end-development)
  - [ML Development](#ml-development)
  - [Database](#database)
  - [Figma Prototyping](#figma-prototyping)
  - [React](#react)
- [API Documentation](#-api-documentation)

- [License](#-license)

---

## 🚀 Overview

<p align="center">
  <img src="https://media.discordapp.net/attachments/1203097072727887966/1203730662700490842/image.png?ex=65d2288a&is=65bfb38a&hm=bafa322476200897d167718ac644c1f76c0cd05c26ba5ca7c97b247c516c5ae4&=&format=webp&quality=lossless&width=1757&height=1141" alt="MAVA Demo">
</p>

**Overview**
One of the biggest issues facing human space travel is the musculoskeletal decay that results from extended time in microgravity. Astronauts fight the effects of this atrophy with vigorous exercise. However, these same astronauts also must complete their mission objectives, and oftentimes preventative measures can be curtailed by a more pressing matter. Furthermore, astronauts who do keep to the training frequently still return to Earth with weakened musculoskeletal systems. To address this issue, we will implement a virtual ‘assistant’ that will track the astronaut’s vitals. This assistant will classify the astronaut’s severity of musculoskeletal atrophy on a scale of ‘OK’ to severe. This solution will help astronauts have a better understanding of when to prioritize their exercise over the mission.

Implementation: We created a user friendly User Interface, where the medical officer aboard a ship can gain meaningful insights on their patient. We managed the database of patients using mongodb, paired with a Spring Restful API to handle CRUD operations. We also attempted to train a deepforest mode to classify our datasets. We generated fake data sets on a combination of thoroughly researched test markers that usually indicate muscloskeletal atrophy. However, ran into a wall trying to combat biased outputs. We ended up successfully being able to train our data sets using Google Platform's Auto AI. As a note, Auto Ai accepts your input data, and the assigned task (in this case binary classification) and selects a model for you. As this is prorietary technology, they do not allow us to export, or view the technical details of the model assign. Despite thisover the coming weeks we will continued to investigate ways in which we can better preprocess our training data set.
### Research

## 💡 Tech Stack

### Front-End Development :🖌️

The front-end of MAVA is built with modern web technologies, ensuring a responsive and user-friendly experience. Key technologies include:
- React
- Html
- CSS

### Back-End Development 🐍

The back-end of MAVA handles data processing, authentication, and more. Key technologies include:

- Python Scripts to generate fake data sets
-Java Springboot handle business logic

### ML-Development 🤖
1. Split generated data set into training and testing sets
2. Transformers establised to extract the differnce in Male and Female acceptable thresholds. ColumnTransformer applies the combined feautures to the relevant columns in the dataset
3. Data pipe line: Preprocess, and then a random forest classifier learns to map X_train and y_train and the feautures associated with them.
Evaluations: .65 precision, .70 accuracy, .59 recall, .63 F1-Score, 


### Database 

MAVA utilizes a robust database system to store and manage health data efficiently. The chosen database technology is:

- MongoDB: Nonstructured databases is a perfect starting point for our application. 
### Figma Prototyping

Before development, MAVA underwent prototyping using Figma to design the user interface. Figma helps in creating a cohesive and intuitive UI/UX.

### React

React is used to build interactive and dynamic components, making the user experience seamless and efficient.

## 🔥 Features

- **Deep Forest Classification**: MAVA uses advanced Deep Forest algorithms for precise health assessments.
- **User-Friendly UI**: A simple and intuitive interface makes it easy to input and analyze health data.
- **Data Visualization**: Visualize health metrics and classification results for informed decision-making.
- **Customization**: Highly customizable for integrating additional indicators and algorithms.


## 📚 API Documentation

Astronaut API Documentation
===========================

Overview: Operations hosted by googe app engine: https://hack-brown.nn.r.appspot.com/
---------
This API provides access to operations related to astronaut entities, including retrieval, creation, update, and deletion of the classified 
astronaut records in our mongodb database.

Endpoints:
----------

1. GET /api/astronauts
   - Description: Retrieve a list of all astronauts.
   - Parameters: None
   - Response: A list of astronaut objects.
   - Status Codes:
     - 200 OK: Successfully retrieved list.

2. GET /api/astronauts/{id}
   - Description: Retrieve a single astronaut by their unique identifier.
   - Path Variables: 
     - id (String): The unique identifier of the astronaut.
   - Response: An astronaut object.
   - Status Codes:
     - 200 OK: Successfully retrieved astronaut.
     - 404 Not Found: Astronaut with the specified ID was not found.

3. GET /api/astronauts/byFirstName/{firstName}
   - Description: Retrieve astronauts by their first name. 
                  Any name operation will pull all records related to the astronaut
   - Path Variables: 
     - firstName (String): The first name of the astronaut.
   - Response: A list of astronaut objects with the specified first name.
   - Status Codes:
     - 200 OK: Successfully retrieved list.

4. GET /api/astronauts/byLastName/{lastName}
   - Description: Retrieve astronauts by their last name.
   - Path Variables: 
     - lastName (String): The last name of the astronaut.
   - Response: A list of astronaut objects with the specified last name.
   - Status Codes:
     - 200 OK: Successfully retrieved list.

5. GET /api/astronauts/byFullName
   - Description: Retrieve astronauts by their full name.
   - Query Parameters: 
     - firstName (String): The first name of the astronaut.
     - lastName (String): The last name of the astronaut.
   - Response: A list of astronaut objects with the specified full name.
   - Status Codes:
     - 200 OK: Successfully retrieved list.

6. POST /api/astronauts
   - Description: Create a new astronaut record.
   - Request Body: An astronaut object (excluding ID, which is generated automatically).
   - Response: The created astronaut object, including its unique identifier.
   - Status Codes:
     - 201 Created: Astronaut successfully created.

7. PUT /api/astronauts/{id}
   - Description: Update an existing astronaut record.
   - Path Variables: 
     - id (String): The unique identifier of the astronaut to update.
   - Request Body: An astronaut object with updated fields.
   - Response: The updated astronaut object.
   - Status Codes:
     - 200 OK: Astronaut successfully updated.
     - 404 Not Found: Astronaut with the specified ID was not found.

8. DELETE /api/astronauts/{id}
   - Description: Delete an astronaut record.
   - Path Variables: 
     - id (String): The unique identifier of the astronaut to delete.
   - Response: None
   - Status Codes:
     - 204 No Content: Astronaut successfully deleted.
     - 404 Not Found: Astronaut with the specified ID was not found.

Note: All endpoints return a 500 Internal Server Error status code in case of server errors.

