## AI Code Review

✅ **Code Quality: Excellent!**

The code is well-structured and mostly free from issues. Here are a few points to address:

- ❌ **Magic Numbers** (-5 points): In the `HotelRoom` class, constants are used for validation but are not used directly in the `Hotel` class to replace numbers like `1`, `2`, `3`, and `4` in the main method’s menu switch. Consider defining named constants for these menu choices within `Hotel`.

- ❌ **Duplicate Code** (-10 points): The `Hotel` class methods `checkIn` and `checkOut` have duplicate error messages. Consider creating a shared method for printing error messages when a room is not available or found.

- Ensure all conditional blocks use braces `{}` even for single statements, which you have adhered to correctly throughout the code.

Recommended adjusted grade: 85%
