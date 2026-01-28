## AI Code Review

Upon reviewing the provided Java files, here are the areas needing attention:

❌ **Duplicate Code** (-10 points)
- In the `Hotel` class, the room checking logic in `checkIn` and `checkOut` methods is similar. Both methods search for a room and verify its occupancy status. Consider extracting this logic into a separate method to reduce duplication.

Everything else looks clean, with appropriate use of constants in `HotelRoom.java` and well-organized methods. The code is generally readable and logically structured.

Recommended adjusted grade: 90%
