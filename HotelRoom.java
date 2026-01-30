/**
 * Represents a room in the hotel.
 */
public class HotelRoom {

    private int _roomNum;
    private int _numBeds;
    private boolean _occupied;
    private String _guest;

    // Constants
    private static final int MIN_ROOM = 100;
    private static final int MAX_ROOM = 999;
    private static final int DEFAULT_ROOM = 999;
    private static final int MIN_BEDS = 2;
    private static final int MAX_BEDS = 4;
    private static final int DEFAULT_BEDS = 2;

    /**
     * Constructor for HotelRoom.
     */
    public HotelRoom(int roomNum, int numBeds) {
        setRoomNum(roomNum);
        setNumBeds(numBeds);
        _occupied = false;
        _guest = "";
    }

    /**
     * Helper method to validate ranges and avoid duplicate code.
     */
    private int validateRange(int value, int min, int max, int defaultValue) {
        if (value >= min && value <= max) {
            return value;
        }
        return defaultValue;
    }

    // Setters - using the helper method to eliminate duplication
    public void setRoomNum(int roomNum) {
        _roomNum = validateRange(roomNum, MIN_ROOM, MAX_ROOM, DEFAULT_ROOM);
    }

    public void setNumBeds(int numBeds) {
        _numBeds = validateRange(numBeds, MIN_BEDS, MAX_BEDS, DEFAULT_BEDS);
    }

    // Getters
    public int getRoomNum() {
        return _roomNum;
    }

    public int getNumBeds() {
        return _numBeds;
    }

    public boolean isOccupied() {
        return _occupied;
    }

    public String getGuest() {
        return _guest;
    }

    /**
     * Checks a guest into the room. Returns true if successful.
     */
    public boolean checkIn(String guest) {
        if (!_occupied) {
            _guest = guest;
            _occupied = true;
            return true;
        }
        return false;
    }

    /**
     * Checks a guest out of the room.
     */
    public void checkOut() {
        _guest = "";
        _occupied = false;
    }

    public boolean before(HotelRoom other) {
        return _roomNum < other.getRoomNum();
    }

    public boolean after(HotelRoom other) {
        return _roomNum > other.getRoomNum();
    }

    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return _roomNum == other.getRoomNum() && _numBeds == other.getNumBeds();
    }

    @Override
    public String toString() {
        String status = _occupied ? "Occupied by " + _guest : "Available";
        return "Room " + _roomNum + ", " + _numBeds + " Beds: " + status;
    }
}
