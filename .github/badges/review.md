## AI Code Review

❌ **Duplicate Code** (-10 points)

- In the `HotelRoom` class, notice that the validation logic for `roomNumOk` and `numBedsOk` is duplicated across the constructor and the setter methods (`setRoomNum` and `setNumBeds`). This logic appears multiple times and should be extracted to avoid redundancy, ensuring the validation appears in one place.

End with: Recommended adjusted grade: 90%
