## Grade

[![Grade](https://img.shields.io/badge/Grade-88%25-green)](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21439062592) *(Original: 98%, Penalties: -10)*

## Tests

[📊 View Test Reports](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21439062592)

## AI Code Review

✅ **Code Quality: Excellent!**

The code is well-structured and readable. However, there are a couple of small points to note:

- ❌ **Duplicate Code** (-10 points): The logic for checking room availability by room number is duplicated in the `checkIn`, `checkOut`, and `findAvailableByBeds` methods. Consider extracting this shared logic into a separate method to reduce duplication and enhance maintainability.

- Overall, great effort on using constants instead of magic numbers. The program flow is logical, and the use of braces and indentation is appropriate.

Recommended adjusted grade: 90%
