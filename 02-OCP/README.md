# Open/Closed Principle (OCP)

**Open/Closed Principle (OCP)** states:

> Software entities (classes, modules, functions) should be  
> **open for extension but closed for modification**.

This means we should be able to **add new behavior** without **changing existing, tested code**.

---

## Problem Context

Consider a shopping system with:
- Products
- A Cart that holds multiple products
- The Cart calculating the total price
- An Invoice Printer for printing invoices
- A Storage mechanism for saving cart data

The design already follows **Single Responsibility Principle (SRP)**:
- Cart calculates total price
- InvoicePrinter prints invoices
- Storage classes handle persistence

However, **SRP alone is not sufficient** to make the system extensible.

---

## ❌ OCP Violation

Initially, the Cart is connected directly to a concrete storage class:

- **CartDBStorage**
  - `saveToDB()` method

This works fine **until requirements change**.

### The problem arises when:

- We want to save to **MongoDB**
- Or save to **file storage**
- Or save to **cloud storage**

To support this, we would need to:
- Modify the Cart
- Or modify existing storage-related logic
- Or add conditional checks (`if/else`)

This means **existing code must be changed** every time a new storage type is added.

### Why this violates OCP

- Existing, working code is modified
- Each new storage type increases coupling
- Risk of introducing bugs grows with every change

📁 OCP-violating examples can be found here:

violation/code
violation/diagram


---

## ✅ OCP-Compliant Solution

To follow OCP, the design is refactored using:

- **Abstraction**
- **Inheritance**
- **Polymorphism**

### Step 1: Introduce an abstraction

An interface (or abstract class) is created:

- **DBPersistence**
  - Defines a common method: `save(cart)`

The Cart now depends on **abstraction**, not a concrete class.

---

### Step 2: Concrete implementations

Different storage mechanisms implement the same abstraction:

- **DBStorage** → saves to database
- **MongoDBStorage** → saves to MongoDB
- **FileStorage** → saves to file system

Each implementation provides its own version of `save()`.

---

### Why this design follows OCP

- The Cart code **never changes**
- New storage types are added by **creating new classes**
- Existing, tested code remains untouched
- Behavior is extended through polymorphism

📁 OCP-compliant examples can be found here:

solution/code
solution/diagram


---

## Key Takeaway

> OCP is about designing your system so that **change happens by addition, not modification**.

When code is open for extension but closed for modification:
- Systems scale safely
- Bugs are reduced
- New features are added with confidence

---

## When to Apply OCP

You should consider OCP when:

- New requirements keep adding `if/else` conditions
- Existing classes need frequent modification
- Behavior changes based on type or configuration
- You anticipate future extensions

OCP works best when combined with:
- SRP (clear responsibilities)
- Abstractions (interfaces or abstract classes)
- Polymorphism (runtime behavior selection)

---

## Final Note

SRP ensures **clean responsibilities**.  
OCP ensures **safe extensibility**.

Both principles together form the foundation of scalable design.
