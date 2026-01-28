## AI Code Review

✅ **Code Quality: Excellent!** 

I've reviewed the provided Java files, and most of the code is well-structured and follows the given rules. There are a few points that need your attention:

❌ **Duplicate Code** (-10 points):  
In the `HotelRoom` class, the constructor and the `setRoomNum` and `setNumBeds` methods have similar validation logic for checking the validity of room numbers and bed numbers. This logic should be placed in one method only to avoid duplication.

❌ **Magic Numbers** (-5 points):  
In the `Hotel` class, when printing the menu choice for beds, the range values (2-4) are used directly. These should be defined as named constants in the `HotelRoom` class (MIN_NUMBEDS and MAX_NUMBEDS) to eliminate magic numbers outside of the main method.

Addressing these issues will improve your code's quality by enhancing maintainability and adherence to best practices. Keep up the great work! Recommended adjusted grade: 85%
