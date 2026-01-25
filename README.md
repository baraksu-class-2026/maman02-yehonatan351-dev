## Grade

[![Grade](https://img.shields.io/badge/Grade-88%25-green)](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21339827578) *(Original: 98%, Penalties: -10)*

## Tests

[📊 View Test Reports](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21339827578)

## AI Code Review

### File: `Hotel.java`

#### ❌ **Duplicate Code** (-10 points)
- **Methods involved**: `checkIn(int, HotelRoom, HotelRoom, HotelRoom)` and `checkOut(int, HotelRoom, HotelRoom, HotelRoom)` both use `findRoomByNumber` and similar logic to check if a room is available. This logic should be refactored so that the room search and availability check do not repeat in each method.
  
#### ❌ **Syntax and Readability Issues** (-5 points)
- The `System.out.println("Hotel Menu :");` has an incorrect newline that affects the readability of the menu in the console output. This newline should be corrected.

### File: `HotelRoom.java`

No issues found in this file. All validations, constants, and logical structures are appropriately handled according to the given rules.

### Recommended Adjusted Grade: 85%
