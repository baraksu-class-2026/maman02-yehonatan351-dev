import java.util.Scanner;

/**
 * Management class for Hotel operations.
 */
public class Hotel {

    // Named constants for Menu Choices to avoid Magic Numbers
    private static final int MENU_DISPLAY_SORTED = 1;
    private static final int MENU_CHECK_IN = 2;
    private static final int MENU_CHECK_OUT = 3;
    private static final int MENU_FIND_BY_BEDS = 4;
    
    // Shared error message to avoid duplication
    private static final String ERR_ROOM_NOT_FOUND = "Error: Room not available or not found";

    /**
     * Displays details of three rooms.
     */
    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * Displays rooms sorted by their room number.
     */
    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        if (a.getRoomNum() > b.getRoomNum()) {
            swapRooms(a, b);
        }
        if (b.getRoomNum() > c.getRoomNum()) {
            swapRooms(b, c);
        }
        if (a.getRoomNum() > b.getRoomNum()) {
            swapRooms(a, b);
        }
        display(a, b, c);
    }

    /**
     * Swaps data between two HotelRoom objects.
     */
    private static void swapRooms(HotelRoom r1, HotelRoom r2) {
        final int tempRoomNum = r1.getRoomNum();
        final int tempNumBeds = r1.getNumBeds();
        final boolean tempIsOccupied = r1.isOccupied();
        final String tempGuestName = r1.getGuest();

        r1.setRoomNum(r2.getRoomNum());
        r1.setNumBeds(r2.getNumBeds());
        
        if (r2.isOccupied()) {
            r1.checkIn(r2.getGuest());
        } else {
            r1.checkOut();
        }

        r2.setRoomNum(tempRoomNum);
        r2.setNumBeds(tempNumBeds);
        
        if (tempIsOccupied) {
            r2.checkIn(tempGuestName);
        } else {
            r2.checkOut();
        }
    }

    /**
     * Searches for a room by its number.
     */
    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom... rooms) {
        for (HotelRoom room : rooms) {
            if (room.getRoomNum() == roomNum) {
                return room;
            }
        }
        return null;
    }

    /**
     * Helper method to reduce duplication in checkIn/checkOut.
     */
    private static HotelRoom getValidatedRoom(int roomNum, boolean shouldBeOccupied, 
                                             HotelRoom... rooms) {
        HotelRoom room = findRoomByNumber(roomNum, rooms);
        if (room != null && room.isOccupied() == shouldBeOccupied) {
            return room;
        }
        return null;
    }

    /**
     * Checks a guest into a room.
     */
    public static void checkIn(String guest, int roomNum, HotelRoom... rooms) {
        HotelRoom room = getValidatedRoom(roomNum, false, rooms);
        if (room != null) {
            room.checkIn(guest);
            System.out.println(room);
        } else {
            System.out.println(ERR_ROOM_NOT_FOUND);
        }
    }

    /**
     * Checks a guest out of a room.
     */
    public static void checkOut(int roomNum, HotelRoom... rooms) {
        HotelRoom room = getValidatedRoom(roomNum, true, rooms);
        if (room != null) {
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println(ERR_ROOM_NOT_FOUND);
        }
    }

    /**
     * Finds available rooms with a specific number of beds.
     */
    public static void findAvailableByBeds(int numBeds, HotelRoom... rooms) {
        boolean found = false;
        for (HotelRoom room : rooms) {
            if (!room.isOccupied() && room.getNumBeds() == numBeds) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available room with the requested number of beds");
        }
    }

    /**
     * Main program loop.
     */
    public static void main(String[] args) {
        HotelRoom r1 = new HotelRoom(307, 4);
        HotelRoom r2 = new HotelRoom(205, 3);
        r2.checkIn("Guest");
        HotelRoom r3 = new HotelRoom(402, 2);

        System.out.println("Hotel Rooms:");
        display(r1, r2, r3);

        System.out.println("\nHotel Menu:");
        System.out.println(MENU_DISPLAY_SORTED + " - Display rooms by room number (ascending)");
        System.out.println(MENU_CHECK_IN + " - Check-in");
        System.out.println(MENU_CHECK_OUT + " - Check-out");
        System.out.println(MENU_FIND_BY_BEDS + " - Find room by number of beds");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");

        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            sc.nextLine();
            handleMenu(choice, sc, r1, r2, r3);
        }
        sc.close();
    }

    private static void handleMenu(int choice, Scanner sc, 
                                  HotelRoom r1, HotelRoom r2, HotelRoom r3) {
        if (choice == MENU_DISPLAY_SORTED) {
            displaySorted(r1, r2, r3);
        } else if (choice == MENU_CHECK_IN) {
            System.out.print("Enter room number: ");
            int num = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter guest name: ");
            String name = sc.nextLine();
            checkIn(name, num, r1, r2, r3);
        } else if (choice == MENU_CHECK_OUT) {
            System.out.print("Enter room number: ");
            int num = sc.nextInt();
            sc.nextLine();
            checkOut(num, r1, r2, r3);
        } else if (choice == MENU_FIND_BY_BEDS) {
            System.out.print("Enter requested number of beds (2-4): ");
            int beds = sc.nextInt();
            sc.nextLine();
            findAvailableByBeds(beds, r1, r2, r3);
        } else {
            System.out.println("Error: Invalid menu choice");
        }
    }
}
