# Product Management System (PMS)

## Introduction

### Overview
The Product Management System (PMS) is designed to manage products across multiple databases, specifically MySQL and MongoDB. The system allows users to create, read, update, and delete product information while maintaining distinct details for each database. It also facilitates categorization and retrieval of products according to their category, sorting them by price, and uses an in-memory binary tree for managing products.

### Objectives
- Provide a unified interface for managing products in both SQL and MongoDB.
- Ensure data integrity and consistency across different storage solutions.
- Facilitate easy access to product information through RESTful APIs.
- Implement interceptors for logging and authentication.

### Scope
The project includes the implementation of product and category management, supporting CRUD operations for both SQL and MongoDB databases.

### Component Descriptions
- **API Gateway:** Manages requests from the client and routes them to appropriate controllers.
- **SQL Database:** Relational database used to store core product and category data.
- **MongoDB:** NoSQL database used to store additional product details.
- **Services:** Business logic layer where operations related to products and categories are implemented.
- **Controllers:** Handles incoming HTTP requests, invoking the corresponding service methods.

## Modules and Components

### SQL Database Module
- **Entities:** Product, Category
- **Repository:** ProductRepo, CategoryRepo

### MongoDB Module
- **Entities:** ProductMongo, CategoryMongo
- **Repository:** ProductRepoMongo, CategoryRepoMongo

### Service Layer
- **Interfaces:** ProductService, ProductServiceMongo, CategoryService, CategoryServiceMongo
- **Implementations:** ProductServiceImpl, ProductServiceImplMongo, CategoryServiceImpl, CategoryServiceImplMongo

### Controller Layer
- **Controllers:** MongoProductController, MongoCategoryController, ProductController, CategoryController

## API Endpoints

### SQL Product API

| Method | Endpoint           | Description            |
|--------|--------------------|------------------------|
| GET    | /api/products      | Retrieve all products  |
| POST   | /api/products      | Create a new product   |
| GET    | /api/products/{id} | Retrieve a product by ID|
| PUT    | /api/products/{id} | Update a product       |
| DELETE | /api/products/{id} | Delete a product       |

### MongoDB Product API

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | /api/mongo/products   | Retrieve all MongoDB products|
| POST   | /api/mongo/products   | Create a new MongoDB product |
| GET    | /api/mongo/products/{id} | Retrieve a MongoDB product by ID |
| PUT    | /api/mongo/products/{id} | Update a MongoDB product     |
| DELETE | /api/mongo/products/{id} | Delete a MongoDB product     |

### Category API

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | /api/categories      | Retrieve all categories |
| POST   | /api/categories      | Create a new category   |
| GET    | /api/categories/{id} | Retrieve a category by ID |
| PUT    | /api/categories/{id} | Update a category       |
| DELETE | /api/categories/{id} | Delete a category       |

### MongoDB Categories API

| Method | Endpoint              | Description                   |
|--------|-----------------------|-------------------------------|
| GET    | /api/mongo/category   | Retrieve all MongoDB categories|
| POST   | /api/mongo/category   | Create a new MongoDB category |
| GET    | /api/mongo/category/{id} | Retrieve a MongoDB category by ID |
| PUT    | /api/mongo/category/{id} | Update a MongoDB category     |
| DELETE | /api/mongo/category/{id} | Delete a MongoDB category     |

## Backend
- **Spring Boot Application:** RESTful API for managing products, categories, and CRUD operations.
- **Dependency Injection:** Implemented for service and repository layers.
- **Interceptors:** For logging and authentication.

## Database

### SQL Database
- Product and category tables for structured data storage.
- Custom queries using JPQL for data retrieval.

### NoSQL Database
- Document-based storage for flexibility in data representation.
- Integration with Spring Data MongoDB for seamless access.

## Binary Tree Structure

### Binary Tree Overview
- **Purpose:** Organize product categories in a hierarchical structure for efficient retrieval and management.
- **Structure:** Each node represents a category with left and right child nodes for hierarchical organization.

### Operations
- **Create:** Insert new products into the tree.
- **Read:** Search for existing products.
- **Update:** Modify product names within the tree.
- **Delete:** Remove product from the tree.

## Deployment

### Deployment Instructions
1. Clone the repository.
2. Set up the databases (MySQL and MongoDB) according to the provided configurations.
3. Build the project using Maven or Gradle.
4. Run the application using your IDE or by executing the packaged JAR.

