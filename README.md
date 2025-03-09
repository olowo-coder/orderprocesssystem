# **Order Processing System (Microservices Architecture)**

This project is a **microservices-based** order processing system consisting of:
1. **Order Service** - Handles order creation and retrieval
2. **Inventory Service** - Manages product stock
3. **Frontend** (Angular) - User interface for placing and viewing orders

All services communicate using **REST and gRPC** and are containerized using **Docker**.

---

## **📌 Features**

✅ **Microservices Architecture** with `Spring Boot`  
✅ **gRPC Communication** between services  
✅ **Angular Frontend** for order placement  
✅ **Dockerized Deployment** using `Docker Compose`  
✅ **CI/CD Ready** with `Maven` for backend builds  
✅ **Networking** handled with `Docker Networks`

---

## **🛠️ Tech Stack**

| Component  | Tech Used                         |
|------------|-----------------------------------|
| **Frontend**  | Angular, TypeScript, Bootstrap    |
| **Backend**  | Java, Spring Boot, gRPC, REST API |
| **Database** | H2 Database                       |
| **Build Tools** | Maven                             |
| **Containerization** | Docker, Docker Compose            |

---

## **📂 Project Structure**  


---

## **🚀 Getting Started**

### **🔹 Prerequisites**
Make sure you have the following installed:
- [Node.js](https://nodejs.org/) & [Angular CLI](https://angular.io/cli)
- [Docker](https://www.docker.com/) & [Docker Compose](https://docs.docker.com/compose/)
- [Java 11+](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org/)

---

## **📦 Setup & Installation**

### **1️ Clone the Repository**
```sh
git clone https://github.com/olowo-coder/orderprocesssystem.git

cd orderprocesssystem
```

### **2 Ensure you branch out to main**

### **3 Run the docker command**
```sh
docker-compose up --build
```

## Access the frontend in the browser
### 🌍 Web App (Angular Frontend)
Once all services are up, access the frontend application:
### 🔗 http://localhost:4200 



## **📌 API Endpoints**

### **🟢 Inventory Service (`8082`)**
| Method | Endpoint | Description |
|--------|---------|------------|
| `GET` | `/api/inventory/products` | Get all available products |

---

### **🟠 Order Service (`8081`)**
| Method | Endpoint | Description |
|--------|---------|------------|
| `POST` | `/api/orders` | Create a new order |
| `GET` | `/api/orders` | Get all orders |
---

### **🟢 gRPC Communication (Between Order & Inventory Service)**
| Service | Method       | Request        | Response        | Description |
|---------|--------------|----------------|-----------------|------------|
| **InventoryService** | `checkStock` | `OrderRequest` | `OrderResponse` | Checks if a product is in stock 

---
