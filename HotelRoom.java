public class HotelRoom {

    private int _roomNum;
    private int _numBeds;
    private boolean _occupied;
    private String _guest;

    public static final int DEFAULT_ROOM_NUM = 999;
    public static final int DEFAULT_NUM_BEDS = 2;
    public static final boolean DEFAULT_OCCUPIED = false;
    public static final String DEFAULT_GUEST = "";

    public static final int MIN_ROOMNUM = 100;
    public static final int MAX_ROOMNUM = 999;
    public static final int MIN_NUMBEDS = 2;
    public static final int MAX_NUMBEDS = 4;

    public HotelRoom(int roomNum, int numBeds) {
        _roomNum = validateRoomNum(roomNum);
        _numBeds = validateNumBeds(numBeds);
        _occupied = DEFAULT_OCCUPIED;
        _guest = DEFAULT_GUEST;
    }

    private int validateRoomNum(int roomNum) {
        if (roomNum >= MIN_ROOMNUM && roomNum <= MAX_ROOMNUM) {
            return roomNum;
        }
        return DEFAULT_ROOM_NUM;
    }

    private int validateNumBeds(int numBeds) {
        if (numBeds >= MIN_NUMBEDS && numBeds <= MAX_NUMBEDS) {
            return numBeds;
        }
        return DEFAULT_NUM_BEDS;
    }

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

    public void setRoomNum(int roomNum) {
        _roomNum = validateRoomNum(roomNum);
    }

    public void setNumBeds(int numBeds) {
        _numBeds = validateNumBeds(numBeds);
    }

    @Override
    public String toString() {
        if (_occupied) {
            return "Room " + _roomNum + ", " + _numBeds + " Beds: Occupied by " + _guest;
        }
        return "Room " + _roomNum + ", " + _numBeds + " Beds: Available";
    }

    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return _roomNum == other._roomNum && _numBeds == other._numBeds;
    }

    public boolean before(HotelRoom other) {
        return _roomNum < other._roomNum;
    }

    public boolean after(HotelRoom other) {
        return other.before(this);
    }

    public boolean checkIn(String guest) {
        if (!_occupied) {
            _guest = guest;
            _occupied = true;
            return true;
        }
        return false;
    }

    public void checkOut() {
        _occupied = false;
        _guest = "";
    }
}
