/**
 * Represents a room in the hotel.
 */
public class HotelRoom {

    private int _roomNum;
    private int _numBeds;
    private boolean _occupied;
    private String _guest;

    // Constants for validation
    private static final int MIN_ROOM = 100;
    private static final int MAX_ROOM = 999;
    private static final int DEFAULT_ROOM = 999;
    private static final int MIN_BEDS = 2;
    private static final int MAX_BEDS = 4;
    private static final int DEFAULT_BEDS = 2;

    /**
     * Constructor for HotelRoom.
     * Uses setter methods to avoid duplicate validation logic.
     */
    public HotelRoom(int roomNum, int numBeds) {
        setRoomNum(roomNum);
        setNumBeds(numBeds);
        _occupied = false;
        _guest = "";
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
     * Sets the room number with validation.
     */
    public void setRoomNum(int roomNum) {
        if (roomNum >= MIN_ROOM && roomNum <= MAX_ROOM) {
            _roomNum = roomNum;
        } else {
            _roomNum = DEFAULT_ROOM;
        }
    }

    /**
     * Sets the number of beds with validation.
     */
    public void setNumBeds(int numBeds) {
        if (numBeds >= MIN_BEDS && numBeds <= MAX_BEDS) {
            _numBeds = numBeds;
        } else {
            _numBeds = DEFAULT_BEDS;
        }
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

    /**
     * Compares two rooms based on room number and beds.
     */
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
