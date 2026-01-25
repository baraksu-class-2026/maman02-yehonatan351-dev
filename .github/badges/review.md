## AI Code Review

### Feedback for `Hotel.java`:

✅ **Code Quality: Excellent!**  
The `Hotel.java` file is well-structured, uses appropriate named constants within the `main()` method, and ensures all conditional statements use braces. The logic flow is clear and readable.

### Feedback for `HotelRoom.java`:

❌ **Duplicate Code** (-10 points)  
- The `roomNumOk(int roomNum)` and `numBedsOk(int numBeds)` methods both check if a value falls within a defined range. The similar validation logic could be extracted into a single method to reduce duplication.
  
Recommended adjusted grade: 90%
