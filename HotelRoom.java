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
        if (roomNumOk(roomNum)) {
            _roomNum = roomNum;
        } else {
            _roomNum = DEFAULT_ROOM_NUM;
        }

        if (numBedsOk(numBeds)) {
            _numBeds = numBeds;
        } else {
            _numBeds = DEFAULT_NUM_BEDS;
        }

        _occupied = DEFAULT_OCCUPIED;
        _guest = DEFAULT_GUEST;
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
        if (roomNumOk(roomNum)) {
            _roomNum = roomNum;
        }
    }

    public void setNumBeds(int numBeds) {
        if (numBedsOk(numBeds)) {
            _numBeds = numBeds;
        }
    }

    private boolean roomNumOk(int roomNum) {
        if (roomNum >= MIN_ROOMNUM && roomNum <= MAX_ROOMNUM) {
            return true;
        } else {
            return false;
        }
    }

    private boolean numBedsOk(int numBeds) {
        if (numBeds >= MIN_NUMBEDS && numBeds <= MAX_NUMBEDS) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (_occupied) {
            return "Room " + _roomNum + ", " + _numBeds + " Beds: Occupied by " + _guest;
        } else {
            return "Room " + _roomNum + ", " + _numBeds + " Beds: Available";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HotelRoom other = (HotelRoom) obj;
        if (_roomNum != other._roomNum) {
            return false;
        }
        if (_numBeds != other._numBeds) {
            return false;
        }
        return true;
    }

    public boolean before(HotelRoom other) {
        if (other == null) {
            return false;
        }
        if (_roomNum < other._roomNum) {
            return true;
        } else {
            return false;
        }
    }

    public boolean after(HotelRoom other) {
        if (other == null) {
            return false;
        }
        if (_roomNum > other._roomNum) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIn(String guest) {
        if (!_occupied) {
            _guest = guest;
            _occupied = true;
            return true;
        } else {
            return false;
        }
    }

    public void checkOut() {
        if (_occupied) {
            _occupied = false;
            _guest = "";
        }
    }
}
