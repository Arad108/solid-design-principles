# Dependency Inversion Principle (DIP)

**Dependency Inversion Principle (DIP)** states:

> High-level modules should not depend on low-level modules.  
> Both should depend on **abstractions**.
>
> Abstractions should not depend on details.  
> Details should depend on abstractions.

In simpler terms:
**Business logic should not be tightly coupled to implementation details.**

---

## Problem Context

Consider an application that needs to **persist data**.

Initially, the application directly uses concrete database classes such as:
- **SQLDatabase**
- **MongoDBDatabase**

Each database class provides a similar method:
- `save(data)`

---

## ❌ DIP Violation

### Initial design

- **Application**
  - Directly depends on `SQLDatabase`
  - Later also depends on `MongoDBDatabase`

The application code explicitly creates and calls these concrete classes.

---

### Why this is a problem

- Application is tightly coupled to database implementations
- Switching from SQL to MongoDB requires modifying application code
- Adding a new database (e.g., Cassandra) forces code changes
- Business logic becomes dependent on infrastructure details

This violates **Dependency Inversion Principle**.

📁 DIP-violating examples can be found here:

violation/code
violation/diagram


---

## ❌ Why this design does not scale

- High-level modules depend on low-level details
- Code becomes rigid and hard to extend
- Testing becomes difficult (databases cannot be mocked easily)
- Changes in infrastructure ripple through business logic

The direction of dependency is **wrong**.

---

## ✅ DIP-Compliant Solution

To follow DIP, dependencies are inverted using **abstraction**.

---

### Step 1: Introduce an abstraction

Create an interface (or abstract class):

- **Persistence**
  - `save(data)`

This represents the **concept of persistence**, not a specific database.

---

### Step 2: Make concrete databases depend on the abstraction

Concrete implementations now implement `Persistence`:

- **SQLDatabase**
- **MongoDBDatabase**
- **CassandraDatabase** (future extension)

Each class provides its own implementation of `save(data)`.

---

### Step 3: Application depends on abstraction

- **Application**
  - Holds a reference to `Persistence`
  - Calls `save(data)` without knowing which database is used

The concrete database is injected into the application at runtime.

---

## Why this design follows DIP

- High-level module (Application) depends on abstraction
- Low-level modules (databases) depend on the same abstraction
- Database implementations can be swapped without changing application code
- Business logic is isolated from infrastructure details

📁 DIP-compliant examples can be found here:

solution/code
solution/diagram


---

## Key Takeaway

> Dependency Inversion is about **controlling the direction of dependency**.

When high-level logic depends on abstractions instead of details:
- Systems become flexible
- Changes become safer
- Code becomes testable and maintainable

---

## When to Apply DIP

You should consider DIP when:

- High-level logic directly uses concrete classes
- Infrastructure changes affect business logic
- Adding new implementations requires modifying core code
- Testing requires real databases or services

DIP is most powerful when combined with:
- **OCP** (easy extension)
- **ISP** (focused abstractions)
- **Dependency Injection**

---

## Final Note

DIP does **not** mean adding abstractions everywhere.

It means:
> **Depending on what is stable (abstractions),  
> not on what is volatile (implementations).**
