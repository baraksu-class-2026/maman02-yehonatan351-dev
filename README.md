## Grade

[![Grade](https://img.shields.io/badge/Grade-90%25-brightgreen)](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21441763359) *(Original: 100%, Penalties: -10)*

## Tests

[📊 View Test Reports](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21441763359)

## AI Code Review

The code is quite well-written and structured. However, there are a couple of areas that require attention in order to improve code quality and adhere to the requirements:

--- File: ./Hotel.java ---
- ✅ **Code Quality: Excellent!** The main logic is clear, and magic numbers are properly used within main() for testing purposes.

--- File: ./HotelRoom.java ---
- ❌ **Duplicate Code** (-10 points)
  - There is duplicate validation logic in the `setRoomNum` and `HotelRoom` constructor. Since the constructor calls the `setRoomNum` method with validation logic already included, eliminate duplicate validation in the constructor.
  - Similarly, duplicate validation exists in `setNumBeds` and the constructor. Utilize the `setNumBeds` within the constructor to avoid duplication.

- ✅ **Magic Numbers:** Constants are used appropriately outside of main for validation purposes, adhering to the guidelines.

- Braces are used consistently within all conditional and loop statements, which is excellent.

Recommended adjusted grade: 90%
