/**
 * Represents a single hotel room.
 */
public class HotelRoom {

    public static final int DEFAULT_ROOM_NUM = 999;
    public static final int DEFAULT_NUM_BEDS = 2;
    public static final boolean DEFAULT_OCCUPIED = false;
    public static final String DEFAULT_GUEST = "";

    public static final int MIN_ROOMNUM = 100;
    public static final int MAX_ROOMNUM = 999;
    public static final int MIN_NUMBEDS = 2;
    public static final int MAX_NUMBEDS = 4;

    private int roomNum;
    private int numBeds;
    private boolean occupied;
    private String guest;

    /**
     * Constructor for HotelRoom.
     */
    public HotelRoom(int roomNum, int numBeds) {
        this.roomNum = validateRoomNum(roomNum);
        this.numBeds = validateNumBeds(numBeds);
        this.occupied = DEFAULT_OCCUPIED;
        this.guest = DEFAULT_GUEST;
    }

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

    public void setRoomNum(int roomNumVal) {
        this.roomNum = validateRoomNum(roomNumVal);
    }

    public void setNumBeds(int numBedsVal) {
        this.numBeds = validateNumBeds(numBedsVal);
    }

    private int validateRoomNum(int roomNumToCheck) {
        if (roomNumToCheck >= MIN_ROOMNUM && roomNumToCheck <= MAX_ROOMNUM) {
            return roomNumToCheck;
        }
        return DEFAULT_ROOM_NUM;
    }

    private int validateNumBeds(int numBedsToCheck) {
        if (numBedsToCheck >= MIN_NUMBEDS && numBedsToCheck <= MAX_NUMBEDS) {
            return numBedsToCheck;
        }
        return DEFAULT_NUM_BEDS;
    }

    public boolean checkIn(String guestName) {
        if (!occupied) {
            this.guest = guestName;
            this.occupied = true;
            return true;
        }
        return false;
    }

    public void checkOut() {
        this.guest = DEFAULT_GUEST;
        this.occupied = DEFAULT_OCCUPIED;
    }

    @Override
    public String toString() {
        String status = "Available";
        if (occupied) {
            status = "Occupied by " + guest;
        }
        return "Room " + roomNum + ", " + numBeds + " Beds: " + status;
    }

    /**
     * Checks if two rooms are equal.
     */
    public boolean equals(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return this.roomNum == other.roomNum && this.numBeds == other.numBeds;
    }

    /**
     * Checks if this room number is before another.
     */
    public boolean before(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return this.roomNum < other.roomNum;
    }

    /**
     * Checks if this room number is after another.
     */
    public boolean after(HotelRoom other) {
        if (other == null) {
            return false;
        }
        return this.roomNum > other.roomNum;
    }
}
