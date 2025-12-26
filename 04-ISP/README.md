# Interface Segregation Principle (ISP)

**Interface Segregation Principle (ISP)** states:

> Clients should not be forced to depend on interfaces  
> they do not use.

In simpler terms:
An interface should be **small and focused**, exposing only the operations
that are relevant to its clients.

---

## Problem Context

Consider a geometric system that models different shapes made of glass.

An initial design introduces a single interface:

- **GlassShape**
  - `area()`
  - `volume()`

Concrete implementations include:
- **Square**
- **Rectangle**
- **Cube**

At first glance, this design appears reasonable.

---

## ❌ ISP Violation

### The issue

- **Square** and **Rectangle** are **2D shapes**
- They only have **area**
- Volume is **not meaningful** for them

However, because they implement `GlassShape`,
they are forced to provide a `volume()` method.

### What happens in practice

- `Square.volume()` throws an exception
- `Rectangle.volume()` throws an exception

These classes are being forced to implement behavior
that **does not make sense for them**.

---

## Why this is a problem

- Interfaces become bloated
- Implementations contain dummy or exception-throwing methods
- Clients may accidentally call unsupported operations
- The design becomes fragile and misleading

This directly violates **Interface Segregation Principle**.

📁 ISP-violating examples can be found here:

violation/code
violation/diagram


---

## ✅ ISP-Compliant Solution

To follow ISP, interfaces are **segregated based on behavior and responsibility**.

---

### Step 1: Create a 2D shape interface

- **TwoDShape**
  - `area()`

This interface represents shapes that exist only in two dimensions.

---

### Step 2: Create a 3D shape interface

- **ThreeDShape**
  - `area()`
  - `volume()`

This interface represents shapes that have volume.

---

### Step 3: Concrete implementations

- **Square**
  - Implements `TwoDShape`
  - Provides `area()`

- **Rectangle**
  - Implements `TwoDShape`
  - Provides `area()`

- **Cube**
  - Implements `ThreeDShape`
  - Provides both `area()` and `volume()`

Each class now depends **only on the interface it actually needs**.

---

## Why this design follows ISP

- No class implements unnecessary methods
- No meaningless exceptions are thrown
- Interfaces are focused and cohesive
- Client code is simpler and safer

📁 ISP-compliant examples can be found here:

solution/code
solution/diagram


---

## Key Takeaway

> Many ISP violations appear as “empty methods” or  
> “methods that throw exceptions”.

If a class is forced to implement behavior it does not need,
the interface is too broad and must be split.

---

## When to Apply ISP

You should consider ISP when:

- Classes implement methods they do not use
- Methods throw `UnsupportedOperationException`
- Interfaces keep growing over time
- Clients depend on more methods than necessary

ISP leads to **cleaner abstractions and safer designs**.
