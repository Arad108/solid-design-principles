# LSP — Return Type Rule (Signature Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Return Type Rule** states:

> A subclass must return a type that is **the same as or a subtype of**
> the return type declared in the base class.

In simpler terms:
A subclass must not return a **less specific or incompatible type**.

---

## What this means

If a base class method promises a certain return type,  
client code relies on that promise.

When a subclass overrides the method:
- It must honor the same return type contract
- It may return a more specific type (covariant return)
- It must not return a more general or unrelated type

---

## Generic Example

### Base class behavior

- Method returns a general but valid type
- Client code uses the returned value safely

### Subclass behavior (Violation)

- Method returns a broader or incompatible type
- Client code assumptions break at runtime

Even if the code compiles, substitution may fail.

---

## Why this violates LSP

- Client code expects a specific return contract
- Subclass weakens that contract
- Substitution becomes unsafe

The subclass no longer behaves as a proper replacement.

---

## Correct Design Approach

To follow LSP:
- Subclasses should return the **same or more specific type**
- Returned values must satisfy all guarantees of the base type
- Behavior must remain compatible with client expectations

If a subclass needs a differ
