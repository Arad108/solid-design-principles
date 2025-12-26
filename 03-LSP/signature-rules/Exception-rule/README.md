# LSP — Exception Rule (Signature Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Exception Rule** states:

> A subclass must **not introduce new or broader exceptions** than those declared by the base class.

In simpler terms:
A subclass should **not surprise the client** by throwing exceptions that the base class does not.

---

## What this means

If a base class method:
- Does not throw any exception, or
- Throws a specific set of exceptions

Then the overridden method in the subclass:
- Must not throw new unchecked exceptions
- Must not throw broader exceptions
- May throw fewer or more specific exceptions

---

## Generic Example

### Base class behavior

- Method executes without throwing exceptions
- Client code relies on this guarantee

### Subclass behavior (Violation)

- Method throws a runtime exception
- Client code is not prepared to handle it

When the subclass replaces the base class:
- Code compiles
- But fails at runtime

---

## Why this violates LSP

- Client code trusts the base class contract
- Subclass changes observable behavior
- Substitution becomes unsafe

The subclass no longer behaves as a valid replacement.

---

## Correct Design Approach

To follow LSP:
- Subclasses should **not introduce new exceptions**
- Exceptions should be equal or more specific
- Error behavior should remain consistent with the base contract

If exceptional behavior is required:
- The abstraction itself may be incorrect
- The hierarchy should be redesigned

---

## Key Takeaway

> A subtype must not be more error-prone than its parent.

Unexpected exceptions are a strong signal that **LSP is being violated**.
