## AI Code Review

✅ **Code Quality: Excellent!**

Both `Hotel` and `HotelRoom` classes are well-written, clear, and follow the provided rules effectively. However, there are a couple of minor points that need to be addressed:

- ❌ **Magic Numbers** (-5 points): The number "999" used in the `HotelRoom` class might be considered a magic number, as it is the default value for `_roomNum`. Consider ensuring all numbers like this are from defined constants, though it appears to tie in with other constants nicely. Please verify if all numbers are intended to be constants.

- The sorting logic in `displaySorted` uses a clearer bubble-sort style that is easy to understand, and considering the small fixed size of the arrays, it's an efficient choice.

- Ensure closed `Scanner` in main (if required by your teacher).

Recommended adjusted grade: 95%
