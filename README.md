
# WISH-LIST MANAGEMENT APP


## Features

- User authentication with Spring Security.
- RESTful API endpoints for wishlist management.
- MySQL integration for storing user information and wishlist items.
- Swagger Documentation
- Unit tests to ensure the reliability of the application.

## Prerequisites

- Java 8 or later
- MySQL
- IntelliJ IDEA or your preferred IDE

## Tools
- DBeaver
- Postman


## Getting Started

### Database Configuration

1. Install and configure MySQL.
2. Create a database for the application.
3. Update `application.properties` with your database configuration.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password

```

## User Authentication

- User authentication is implemented using Spring Security.
- In-memory authentication has been set up for demonstration purposes.
- Update authentication configuration in WebSecurityConfig.java for production use.


## Wishlist Management
- The application provides RESTful API endpoints for wishlist management.
- Endpoints:
- GET /api/wishlists/get : Retrieve a user's wishlist.
- POST /api/wishlist/add : Create a new wishlist item.
- DELETE /api/wishlist/delete/id=1 : Remove a wishlist item by ID.
- Only authenticated users can access and manage their wishlists.

## Key Features
``` Interactive API Interface: _The user-friendly interface allows seamless interaction with API endpoints.

Effortless Authentication: _ Server-side authentication handles user verification, integrating secure access tokens into the header for authorization.

Complete CRUD Operations: _Perform Create, Read, Update, and Delete operations on customers through API endpoints.

Data Visualization: _ Utilize tables and forms for effective data visualization.
```

## Installation
Clone the repository:
```
git clone https://github.com/rahuldewangan275/wishlist-assesment.git
```

## Features Walkthrough
Logging In: Log in with your login ID and password. After successful authentication, you can access the above api end points.

Exploring Endpoints: Navigate through different endpoints.

NOTE: I have used inmemory authentication so make sure you have entered the user details in user table before performing endpoints:

- User name and Passwords
```
1.user: user1
  password: user1Pass
2.user: user2
  password: user2Pass
3.user: user3
  password: user3Pass
```

## Contributing
We welcome contributions from the community! If you're interested in enhancing [Your Project Name], follow these steps:

1 Fork the Repository: Create your personal fork of the repository.

2 Create a Feature Branch: Begin a new branch for your feature or enhancement.

3 Make Enhancements: Make improvements and additions to the project.

4 Submit a Pull Request: Submit your changes for review, and we'll collaborate on merging them.

### Thanks for visiting 
- any queries mail: rahuldewangan275@gmail.com
