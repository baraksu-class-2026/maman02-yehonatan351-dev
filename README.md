## Grade

[![Grade](https://img.shields.io/badge/Grade-88%25-green)](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21438050286) *(Original: 98%, Penalties: -10)*

## Tests

[📊 View Test Reports](https://github.com/baraksu-class-2026/maman02-yehonatan351-dev/actions/runs/21438050286)

## AI Code Review

✅ **Code Quality: Excellent!**

The provided Java files are well-structured, readable, and logically organized. The code adheres to the specified guidelines, with a few areas where improvements can enhance clarity and maintainability:

❌ **Duplicate Code** (-10 points)

- The methods `checkIn` and `checkOut` in the `Hotel` class both perform similar logic to find a room by its number. The logic to determine which room object corresponds to the input room number is identical in both methods. Consider extracting the shared logic into a separate method or utilize `findRoomByNumber` to reduce duplication.

- In the `HotelRoom` class, the validation logic for checking room number and number of beds (`roomNumOk` and `numBedsOk`) is repeated in both the constructors and setters. While this can sometimes be necessary, streamlining by centralizing validation logic could improve maintainability.

Overall, great job on following the indentation and brace usage rules, and avoiding magic numbers outside of the main method. Keep up the good work, and with these minor adjustments, your code will be even more efficient and simpler to maintain. Recommended adjusted grade: 90% (-10 points for duplicate code)
