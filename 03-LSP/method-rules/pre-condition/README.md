# LSP — Pre-condition Rule (Method Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Pre-condition Rule** states:

> A subclass must **not strengthen the preconditions**
> of a method it overrides.

In simpler terms:
A subclass must not demand **more restrictive input conditions**
than those required by the base class.

---

## What is a Pre-condition?

A pre-condition defines **what must be true before a method is executed**.

Client code relies on these conditions to know:
- When it is safe to call a method
- What inputs are considered valid

---

## Problem Context

Consider a base class:

- **User**
  - Method: `createPassword(password)`
  - Pre-condition:  
    - Password length **≥ 8**

From the client’s perspective:
> “Any User accepts passwords of length 8 or more.”

---

## ✅ Weakening the Pre-condition (Allowed)

A subclass is introduced:

- **AdminUser**
  - Inherits from `User`
  - Overrides `createPassword(password)`
  - Pre-condition:  
    - Password length **≥ 6**

### Why this does NOT violate LSP

- The subclass accepts **all valid inputs** of the base class
- It even accepts **more inputs**
- Client code that works with `User` will still work with `AdminUser`

The pre-condition is **weakened**, which is allowed under LSP.

---

## ❌ Strengthening the Pre-condition (Violation)

A violation occurs if the subclass defines:

- Password length **≥ 10**

### Why this violates LSP

- The base class allows passwords of length 8 or 9
- The subclass rejects valid inputs accepted by the base class
- Client code breaks when the subclass is substituted

This breaks substitutability.

---

## Why Strengthening Preconditions Is Dangerous

- Valid inputs suddenly become invalid
- Client code must add defensive checks
- Behavior changes unexpectedly at runtime
- The subclass no longer honors the base contract

---

## Key Takeaway

> A subtype may accept **less restrictive inputs**,  
> but must never demand **more restrictive inputs** than its parent.

Weakening pre-conditions preserves substitutability.  
Strengthening them violates LSP.
