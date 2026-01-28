public class HotelRoom {

    private int roomNum;
    private int numBeds;
    private boolean occupied;
    private String guest;

    public static final int DEFAULT_ROOM_NUM = 999;
    public static final int DEFAULT_NUM_BEDS = 2;
    public static final boolean DEFAULT_OCCUPIED = false;
    public static final String DEFAULT_GUEST = "";

    public static final int MIN_ROOMNUM = 100;
    public static final int MAX_ROOMNUM = 999;
    public static final int MIN_NUMBEDS = 2;
    public static final int MAX_NUMBEDS = 4;

    // ---------------- Constructor ----------------
    public HotelRoom(int roomNum, int numBeds) {
        this.roomNum = validateRoomNum(roomNum);
        this.numBeds = validateNumBeds(numBeds);
        this.occupied = DEFAULT_OCCUPIED;
        this.guest = DEFAULT_GUEST;
    }

    // ---------------- Getters ----------------
    public int getRoomNum() {
        return roomNum;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getGuest() {
        return guest;
    }

    // ---------------- Setters ----------------
    public void setRoomNum(int roomNum) {
        this.roomNum = validateRoomNum(roomNum);
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = validateNumBeds(numBeds);
    }

    // ---------------- Validation ----------------
    private int validateRoomNum(int roomNum) {
        if (roomNum >= MIN_ROOMNUM && roomNum <= MAX_ROOMNUM) {
            return roomNum;
        } else {
            return DEFAULT_ROOM_NUM;
        }
    }

    private int validateNumBeds(int numBeds) {
        if (numBeds >= MIN_NUMBEDS && numBeds <= MAX_NUMBEDS) {
            return numBeds;
        } else {
            return DEFAULT_NUM_BEDS;
        }
    }

    // ---------------- Room status ----------------
    public boolean checkIn(String guest) {
        if (!occupied) {
            this.guest = guest;
            this.occupied = true;
            return true;
        } else {
            return false;
        }
    }

    public void checkOut() {
        this.guest = "";
        this.occupied = false;
    }

    // ---------------- Utility ----------------
    @Override
    public String toString() {
        if (occupied) {
            return "Room " + roomNum + ", " + numBeds + " Beds: Occupied by " + guest;
        } else {
            return "Room " + roomNum + ", " + numBeds + " Beds: Available";
        }
    }

    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return this.roomNum == other.roomNum && this.numBeds == other.numBeds;
    }

    public boolean before(HotelRoom other) {
        return this.roomNum < other.roomNum;
    }

    public boolean after(HotelRoom other) {
        return other.before(this);
    }
}
