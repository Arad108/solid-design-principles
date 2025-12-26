# LSP — Post-condition Rule (Method Rule)

Under the **Liskov Substitution Principle (LSP)**, the **Post-condition Rule** states:

> A subclass must **not weaken the post-conditions**
> of a method it overrides.

In simpler terms:
After a method finishes executing, a subclass must guarantee
**at least what the base class guarantees** — it may guarantee more, but never less.

---

## What is a Post-condition?

A post-condition describes **what must be true after a method executes**.

Client code relies on these guarantees to reason about program behavior.

---

## Problem Context

Consider a base class:

- **Car**
  - Has a `speed`
  - Method: `brake()`
  - Post-condition:  
    - The car’s speed is reduced

From the client’s perspective:
> “Calling `brake()` will always slow down the car.”

---

## ✅ Strengthening the Post-condition (Allowed)

A subclass is introduced:

- **ElectricCar**
  - Overrides `brake()`
  - Slows down the car **and**
  - Slightly charges the battery through regenerative braking

### Why this does NOT violate LSP

- The original guarantee (“car slows down”) is preserved
- Additional behavior (battery charging) does not break client expectations
- The post-condition is **strengthened**, not weakened

Any code that works with `Car` still works correctly with `ElectricCar`.

---

## ❌ What Would Violate the Post-condition Rule

A violation would occur if the subclass:
- Does not reduce speed
- Reduces speed inconsistently
- Changes braking behavior in a way that breaks the base guarantee

In such cases, substitution would no longer be safe.

---

## Why Strengthening is Allowed

LSP allows subclasses to:
- Do **more** than the base class promises
- Provide additional guarantees
- Enhance behavior without breaking existing contracts

What is not allowed is doing **less**.

---

## Key Takeaway

> A subclass may improve the outcome of a method,
> but must never reduce the guarantees promised by the base class.

Strengthening post-conditions preserves substitutability
and is fully compatible with LSP.
