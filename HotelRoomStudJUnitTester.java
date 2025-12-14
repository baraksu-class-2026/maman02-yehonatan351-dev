import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelRoomStudJUnitTester {
    
    private HotelRoom room;
    
    @BeforeEach
    public void setUp() {
        // Initialize a fresh room object before each test
        room = new HotelRoom(205, 3);
    }
    
    @Test
    public void testToString() {
        // Test the string representation of an available room
        assertEquals("Room 205, 3 Beds: Available", room.toString(),
                     "toString should return correct format for available room");
    }
    
    @Test
    public void testGetRoomNum() {
        // Test getting the room number
        assertEquals(205, room.getRoomNum(),
                     "getRoomNum should return 205");
    }
    
    @Test
    public void testGetNumBeds() {
        // Test getting the number of beds
        assertEquals(3, room.getNumBeds(),
                     "getNumBeds should return 3");
    }
    
    @Test
    public void testIsOccupiedInitially() {
        // Test that a new room is not occupied
        assertFalse(room.isOccupied(),
                    "New room should not be occupied");
    }
    
    @Test
    public void testSetRoomNum() {
        // Test setting a new room number
        room.setRoomNum(450);
        assertEquals(450, room.getRoomNum(),
                     "Room number should be updated to 450");
    }
    
    @Test
    public void testSetNumBeds() {
        // Test setting a new number of beds
        room.setNumBeds(4);
        assertEquals(4, room.getNumBeds(),
                     "Number of beds should be updated to 4");
    }
    
    @Test
    public void testCheckIn() {
        // Test checking in a guest
        boolean result = room.checkIn("Dana");
        assertTrue(result, "checkIn should return true for available room");
        assertTrue(room.isOccupied(), "Room should be occupied after check-in");
        assertEquals("Dana", room.getGuest(), "Guest name should be Dana");
    }
    
    @Test
    public void testGetGuest() {
        // Test getting guest name after check-in
        room.checkIn("Dana");
        assertEquals("Dana", room.getGuest(),
                     "getGuest should return Dana");
    }
    
    @Test
    public void testCheckOut() {
        // Test checking out a guest
        room.checkIn("Dana");
        room.checkOut();
        assertFalse(room.isOccupied(),
                    "Room should not be occupied after checkout");
    }
    
    @Test
    public void testEquals() {
        // Test equals method with different rooms
        HotelRoom room2 = new HotelRoom(317, 2);
        HotelRoom room3 = new HotelRoom(521, 3);
        
        assertFalse(room.equals(room3),
                    "Rooms with different numbers should not be equal");
    }
    
    @Test
    public void testEqualsSameRoom() {
        // Test equals with same room number
        HotelRoom room2 = new HotelRoom(205, 3);
        assertTrue(room.equals(room2),
                   "Rooms with same number should be equal");
    }
    
    @Test
    public void testBefore() {
        // Test before method - room 317 should come before room 521
        HotelRoom room2 = new HotelRoom(317, 2);
        HotelRoom room3 = new HotelRoom(521, 3);
        
        assertTrue(room2.before(room3),
                   "Room 317 should come before room 521");
    }
    
    @Test
    public void testBeforeFalse() {
        // Test before method returns false when room number is greater
        HotelRoom room2 = new HotelRoom(317, 2);
        HotelRoom room3 = new HotelRoom(521, 3);
        
        assertFalse(room3.before(room2),
                    "Room 521 should not come before room 317");
    }
    
    @Test
    public void testAfter() {
        // Test after method - room 521 should come after room 317
        HotelRoom room2 = new HotelRoom(317, 2);
        HotelRoom room3 = new HotelRoom(521, 3);
        
        assertFalse(room2.after(room3),
                    "Room 317 should not come after room 521");
    }
    
    @Test
    public void testAfterTrue() {
        // Test after method returns true when room number is greater
        HotelRoom room2 = new HotelRoom(317, 2);
        HotelRoom room3 = new HotelRoom(521, 3);
        
        assertTrue(room3.after(room2),
                   "Room 521 should come after room 317");
    }
    
    @Test
    public void testCheckInOccupiedRoom() {
        // Test checking in to an already occupied room
        room.checkIn("Dana");
        boolean result = room.checkIn("John");
        
        assertFalse(result, "checkIn should return false for occupied room");
        assertEquals("Dana", room.getGuest(), 
                     "Guest should remain Dana, not changed to John");
    }
    
    @Test
    public void testToStringOccupied() {
        // Test toString for an occupied room
        room.checkIn("Dana");
        assertEquals("Room 205, 3 Beds: Occupied by Dana", room.toString(),
                     "toString should show occupied status with guest name");
    }
    
    @Test
    public void testMultipleCheckouts() {
        // Test multiple checkouts (edge case)
        room.checkIn("Dana");
        room.checkOut();
        room.checkOut(); // Second checkout
        
        assertFalse(room.isOccupied(),
                    "Room should remain available after multiple checkouts");
    }
}
