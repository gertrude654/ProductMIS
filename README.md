1. Introduction
Overview
The Product Management System (PMS) is designed to manage products across multiple databases, specifically mySql and MongoDB. The system allows users to create, read, update, and delete product information while maintaining distinct details for each database. The system allows also to categorize products and retrieve them according to their category, sort them according to price and use inner memory of binary tree for managing products 
Objectives
To provide a unified interface for managing products in both SQL and MongoDB.
To ensure data integrity and consistency across different storage solutions.
To facilitate easy access to product information through RESTful APIs.
To ensure interceptors of logging and authentication
Scope
This project includes the implementation of product and category management, supporting CRUD operations for both SQL and MongoDB databases.

2. System Architecture
Class Diagram


Entity Relationship Diagram

Component Descriptions
API Gateway: Manages requests from the client and routes them to appropriate controllers.
SQL Database: Relational database used to store core product and category data.
MongoDB: NoSQL database used to store additional product details.
Services: Business logic layer where operations related to products and categories are implemented.
Controllers: Handles incoming HTTP requests, invoking the corresponding service methods.
3. Modules and Components
SQL Database Module
Entities: Product, Category
Repository: ProductRepo, CategoryRepo
MongoDB Module
Entities: ProductMongo, CategoryMongo
Repository: ProductRepoMongo, CategoryRepoMongo
Service Layer
Interfaces: ProductService, ProductServiceMongo,CategoryService, CategoryServiceMongo
Implementations: ProductServiceImpl, ProductServiceImplMongo,CategoryServiceImpl, CategoryServiceImplMongo
Controller Layer
Controllers: MongoProductController, MongoCategoryController, ProductController, CategoryController

4. API Endpoints
SQL Product API


Method
Endpoint
Description
GET
/api/products
Retrieve all products
POST
/api/products
Create a new  product
GET
/api/products/{id}
Retrieve a  product by ID
PUT
/api/products/{id}
Update a  product
DELETE
/api/products/{id}
Delete a  product

MongoDB Product API

Method
Endpoint
Description
GET
/api/mongo/products
Retrieve all MongoDB products
POST
/api/mongo/products
Create a new MongoDB product
GET
/api/mongo/products/{id}
Retrieve a MongoDB product by ID
PUT
/api/mongo/products/{id}
Update a MongoDB product
DELETE
/api/mongo/products/{id}
Delete a MongoDB product

Category API


Method
Endpoint
Description
GET
/api/categories
Retrieve all categories
POST
/api/categories
Create a new category
GET
/api/categories/{id}
Retrieve a category by ID
PUT
/api/mongo/categories/{id}
Update a category
DELETE
/api/categories/{id}
Delete a category


MongoDB Categories API

Method
Endpoint
Description
GET
/api/mongo/category
Retrieve all MongoDB category
POST
/api/mongo/category
Create a new MongoDB category
GET
/api/mongo/category/{id}
Retrieve a MongoDB category by ID
PUT
/api/mongo/category/{id}
Update a MongoDB category
DELETE
/api/mongo/category/{id}
Delete a MongoDB category


4.2 Backend
Spring Boot Application:
RESTful API for managing product , categories and CRUD operations.
Dependency Injection.
Interceptors for logging and authentication.
4.3 Database
SQL Database:
Product and category tables for structured data storage.
Custom queries using JPQL for data retrieval.
NoSQL Database:
Document-based storage for flexibility in data representation.
Integration with Spring Data MongoDB for seamless access.
5. Binary Tree Structure
5.1 Binary Tree Overview
Purpose: Organize product categories in a hierarchical structure for efficient retrieval and management.
Structure:
Each node represents a category with left and right child nodes for hierarchical organization.
5.2 Operations
CRUD Operations:
Create: Insert new products into the tree.
Read: Search for existing products.
Update: Modify product names within the tree.
Delete: Remove product from the tree.
6. Deployment
Deployment Instructions
Clone the repository.
Set up the databases (MySQL and MongoDB) according to the provided configurations.
Build the project using Maven or Gradle.
Run the application using your IDE or by executing the packaged JAR.

