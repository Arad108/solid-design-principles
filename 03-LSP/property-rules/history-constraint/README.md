# LSP — History Constraint Rule (Property Rule)

Under the **Liskov Substitution Principle (LSP)**, the **History Constraint Rule** states:

> A subclass must not **change the allowed state transitions**
> defined by its base class.

In simple terms:
If a base class allows an operation in a certain state,
the subclass must also allow it in that same state.

---

## What is a History Constraint?

A history constraint defines **how an object is allowed to evolve over time**.

It specifies:
- What operations are valid
- In which states they are valid
- How state transitions are expected to behave

Client code relies on these guarantees when interacting with the object.

---

## Problem Context

Consider a base class:

- **Account**
  - Has a `balance`
  - Supports `withdraw()`
  - Withdrawal is allowed whenever the account is in a valid state

From the client’s perspective:
> “Any Account can be withdrawn from.”

---

## ❌ History Constraint Violation

A subclass is introduced:

- **FixedDepositAccount**
  - Inherits from `Account`
  - Overrides `withdraw()`
  - Throws an exception instead of allowing withdrawal

### Why this violates LSP

- The base class allows `withdraw()`
- The subclass **removes** this allowed behavior
- The object’s valid operation history is changed

When the subclass replaces the base class:
- Client code compiles
- But fails at runtime due to unexpected exceptions

This breaks substitutability.

---

## Why this is dangerous

- Allowed operations become conditionally invalid
- Client code must add defensive checks
- Runtime failures replace compile-time safety
- Trust in the abstraction is lost

The subclass **restricts behavior over time**, which is forbidden.

---

## ✅ Correct Design Approach

To follow LSP:
- Subclasses must not remove previously allowed operations
- State transitions must remain compatible
- If an operation is not always valid:
  - It should not exist in the base class
  - The abstraction must be redesigned

A common solution is:
- Separating withdrawable and non-withdrawable account types
- Designing abstractions based on capabilities

---

## Key Takeaway

> A subclass must not rewrite the behavioral history
> promised by its base class.

If an operation was valid before,
it must remain valid after substitution.

Violating history constraints is a subtle but serious LSP violation.
