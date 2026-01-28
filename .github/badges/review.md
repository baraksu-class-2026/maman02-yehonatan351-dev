## AI Code Review

Great job on the code! However, there are a couple of points that need your attention:

❌ **Duplicate Code** (-10 points)
- In the `HotelRoom` class, the logic for checking room number and number of beds appears in both the constructor and the setter methods (`setRoomNum` and `setNumBeds`). This validation logic should be extracted into a separate method or approach so that it exists in only one place in order to reduce duplication and improve maintainability.

❌ **Magic Numbers** (-5 points)
- In the `HotelRoom` class constructor, there are direct checks against the bounds for room numbers and beds (e.g., 307, 4, 205, 3, 402, 2 in `Hotel.main()`). Ensure that these checks use the defined constants (`MIN_ROOMNUM`, `MAX_ROOMNUM`, `MIN_NUMBEDS`, `MAX_NUMBEDS`) consistently.

Recommended adjusted grade: 85%
