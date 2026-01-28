## AI Code Review

✅ **Code Quality: Excellent!**

Your code is well-structured, readable, and logically organized. Here are a few points to address:

- ❌ **Duplicate Code** (-10 points): In `HotelRoom.java`, the validation logic for room numbers (`roomNumOk`) and bed counts (`numBedsOk`) appears multiple times, both in constructor and setter methods. Consider refactoring to ensure these checks are performed in one method only within the class to avoid duplication. Shared logic should be extracted to central places to enhance maintainability.

Recommended adjusted grade: 90%
