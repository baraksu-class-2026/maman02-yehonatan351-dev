## AI Code Review

✅ **Code Quality: Excellent!** Your code is well-organized, and the logic flows smoothly. It adheres to the given standards for using braces and managing logic within the `Hotel` and `HotelRoom` classes. Additionally, there are no issues with magic numbers as they are correctly replaced by named constants outside the `main()` method.

❌ **Duplicate Code** (-10 points): There is duplicate code in the `HotelRoom` class. The validation logic for room numbers and bed counts is identical in both the constructor and the respective setter methods (`setRoomNum` and `setNumBeds`). You should refactor this logic into a separate method to avoid duplication and ensure the code is easier to maintain and modify if needed. This method would allow both the constructor and setter methods to share the same validation logic, reducing redundancy. 

Recommended adjusted grade: 90%
