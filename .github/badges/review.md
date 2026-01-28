## AI Code Review

✅ **Code Quality: Excellent!**

The code is well-structured and readable. However, there are a couple of small points to note:

- ❌ **Duplicate Code** (-10 points): The logic for checking room availability by room number is duplicated in the `checkIn`, `checkOut`, and `findAvailableByBeds` methods. Consider extracting this shared logic into a separate method to reduce duplication and enhance maintainability.

- Overall, great effort on using constants instead of magic numbers. The program flow is logical, and the use of braces and indentation is appropriate.

Recommended adjusted grade: 90%
