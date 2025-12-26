# Single Responsibility Principle (SRP)

**Single Responsibility Principle (SRP)** states:

> A class should have only **one reason to change**.

In other words, a class should be responsible for **only one thing**.

When a class takes on multiple responsibilities, changes in one responsibility
can unintentionally affect the others, making the code harder to maintain and extend.

---

## Problem Context

Consider a simple shopping system with:
- Products
- A Shopping Cart that holds multiple products

At first glance, it may seem convenient to put all related logic inside a single
`ShoppingCart` class.

However, this approach often leads to **violations of SRP** as the system grows.

---

## ❌ SRP Violation

In the violating design, the `ShoppingCart` class is responsible for:

1. **Calculating total price**
2. **Printing the invoice**
3. **Saving cart data to a database**

This means the class has **multiple reasons to change**, such as:
- Pricing rules changing
- Invoice format changing
- Database or storage mechanism changing

### Why this is a problem

- A change in invoice format requires modifying `ShoppingCart`
- A change in storage (DB → file → API) requires modifying `ShoppingCart`
- Business logic becomes tightly coupled with I/O concerns

As a result, the class becomes:
- Harder to test
- Harder to extend
- More fragile over time

📁 Violating examples can be found here:

violation/code
violation/diagram


---

## ✅ SRP-Compliant Solution

To follow SRP, responsibilities are **separated into dedicated classes**, each
handling a single concern.

### Responsibilities after refactoring

- **ShoppingCart**
  - Manages products
  - Calculates total price

- **CartInvoicePrinter**
  - Responsible only for printing the invoice

- **CartDBStorage**
  - Responsible only for saving cart data to the database

Each class now has **only one reason to change**.

### Benefits of this design

- Changes in invoice format do not affect cart logic
- Changes in storage do not affect pricing logic
- Each class is easier to understand and test
- The system becomes more flexible and maintainable

📁 Corrected design examples can be found here:

📁 Corrected design examples can be found here:

- [`solution/code`](./solution/code)
- [`solution/diagram`](./solution/diagram)


---

## Key Takeaway

> SRP is not about creating more classes unnecessarily.  
> It is about **protecting your code from unrelated changes**.

When each class has a single responsibility:
- Code scales better
- Bugs are easier to isolate
- Design remains clean as requirements grow

---

## When to Apply SRP

You should consider applying SRP when:

- A class feels “too powerful”
- A class changes frequently for different reasons
- Modifying one feature breaks unrelated functionality
- Testing a class becomes difficult due to mixed concerns

SRP is often the **first design principle** that reveals deeper architectural problems.
