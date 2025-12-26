# LSP — Method Argument Rule (Signature Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Method Argument Rule** states:

> A subclass must **not strengthen the preconditions** of a method it overrides.

In simpler terms:
A subclass should accept **at least the same range of inputs** as its parent class.

---

## What this means

If a base class method accepts a certain type or range of arguments,  
then the overridden method in the subclass **must not be more restrictive**.

Otherwise, substituting the subclass for the parent can break client code.

---

## Generic Example

### Base class

- Accepts a **general input**
- Makes minimal assumptions about arguments

### Subclass (Violation)

- Narrows the accepted input
- Rejects valid inputs that the base class allows

This causes a problem when client code:
- Works correctly with the base class
- Breaks when a subclass instance is substituted

---

## Why this violates LSP

- Client code relies on the base class contract
- Subclass changes the method’s expectations
- Substitution becomes unsafe

The subclass no longer behaves like a true subtype.

---

## Correct Design Approach

To follow LSP:
- Subclasses should **accept the same or broader arguments**
- Preconditions should remain the same or be weakened
- Behavior should remain compatible with the base class contract

---

## Key Takeaway

> A subclass should never demand *more* from its inputs than its parent.

Strengthening method arguments is a subtle but common source of LSP violations.
