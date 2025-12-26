# LSP — Signature Rules

Under the **Liskov Substitution Principle (LSP)**, **Signature Rules** define how
a subclass may legally override a method **without breaking substitutability**.

Method signatures form a **contract** between a base class and its clients.
Any change to this contract in a subclass can make substitution unsafe.

---

## What are Signature Rules?

Signature rules govern **how method signatures may change** in subclasses, including:

- Method arguments
- Return types
- Thrown exceptions

These rules ensure that a subclass remains a valid replacement for its base class.

---

## Types of Signature Rules

### 1. Method Argument Rule
A subclass must **not strengthen preconditions** by narrowing accepted inputs.

> Subtypes should accept at least the same range of arguments as their parent.

---

### 2. Return Type Rule
A subclass must return the **same type or a subtype** of the base class return type.

> Subtypes may specialize what they return, but must not generalize it.

---

### 3. Exception Rule
A subclass must **not introduce new or broader exceptions** than the base class.

> Subtypes should not surprise clients with unexpected failures.

---

## Why Signature Rules Matter

Violating signature rules leads to:
- Runtime failures
- Unexpected exceptions
- Broken client assumptions
- Unsafe substitution

Even if code compiles, **behavioral correctness may be broken**.

---

## Key Insight

> Method signatures are part of the public contract.

If a subclass changes how a method:
- accepts inputs,
- returns outputs, or
- signals failure,

then **LSP is likely being violated**.

---

## Next Sections

Each signature rule is explained separately with:
- A focused explanation
- Generic examples
- Code and diagrams

Refer to the subfolders for detailed coverage.
