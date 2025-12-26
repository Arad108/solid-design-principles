# LSP — Class Invariant Rule (Property Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Class Invariant Rule** states:

> A subclass must **preserve all invariants** of its base class.

A **class invariant** is a condition that must always hold true
for any valid instance of the class.

---

## What is a Class Invariant?

A class invariant represents a **guarantee** about the internal state of an object.

If a base class defines an invariant,  
every subclass must respect and maintain it.

---

## Problem Context

Consider a base class:

- **Account**
  - Has a `balance`
  - Invariant: `balance >= 0`

This means:
- An account can never have a negative balance
- Client code relies on this guarantee

---

## ❌ Class Invariant Violation

A subclass inherits from `Account` but breaks the invariant:

- **ChildAccount**
  - Allows `balance = -1`

### Why this violates LSP

- Client code assumes `balance >= 0` for any `Account`
- Substituting the subclass breaks that assumption
- Internal consistency of the system is violated

Even if the code compiles, the **behavioral contract is broken**.

---

## Why this is dangerous

- Invalid object states become possible
- Bugs appear far from the source
- Client code must add defensive checks
- Trust in the base abstraction is lost

This makes substitution unsafe.

---

## ✅ Correct Design Approach

To follow LSP:
- Subclasses must **never weaken base class invariants**
- All inherited guarantees must remain true
- If a subclass cannot satisfy an invariant:
  - The inheritance hierarchy is incorrect
  - The abstraction must be redesigned

---

## Key Takeaway

> A subclass must be **at least as correct** as its base class.

If a base class guarantees a condition,
every subclass must uphold it — **without exception**.

Breaking class invariants is a direct violation of LSP.
