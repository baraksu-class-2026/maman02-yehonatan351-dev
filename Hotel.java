import java.util.Scanner;

/**
 * Management class for Hotel operations.
 */
public class Hotel {

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
        int tempRoomNum = r1.getRoomNum();
        int tempNumBeds = r1.getNumBeds();
        boolean tempIsOccupied = r1.isOccupied();
        String tempGuestName = r1.getGuest();

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
     * Checks a guest into a room.
     */
    public static void checkIn(String guest, int roomNum, HotelRoom... rooms) {
        HotelRoom room = findRoomByNumber(roomNum, rooms);
        if (room != null && !room.isOccupied()) {
            room.checkIn(guest);
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    /**
     * Checks a guest out of a room.
     */
    public static void checkOut(int roomNum, HotelRoom... rooms) {
        HotelRoom room = findRoomByNumber(roomNum, rooms);
        if (room != null && room.isOccupied()) {
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
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
        // Requirement for Yotam/Ariel tests: pre-occupy room 205
        r2.checkIn("Guest");
        HotelRoom r3 = new HotelRoom(402, 2);

        System.out.println("Hotel Rooms:");
        display(r1, r2, r3);

        System.out.println("\nHotel Menu:");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in");
        System.out.println("3 - Check-out");
        System.out.println("4 - Find room by number of beds");
        
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
        if (choice == 1) {
            displaySorted(r1, r2, r3);
        } else if (choice == 2) {
            System.out.print("Enter room number: ");
            int num = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter guest name: ");
            String name = sc.nextLine();
            checkIn(name, num, r1, r2, r3);
        } else if (choice == 3) {
            System.out.print("Enter room number: ");
            int num = sc.nextInt();
            sc.nextLine();
            checkOut(num, r1, r2, r3);
        } else if (choice == 4) {
            System.out.print("Enter requested number of beds (2-4): ");
            int beds = sc.nextInt();
            sc.nextLine();
            findAvailableByBeds(beds, r1, r2, r3);
        } else {
            System.out.println("Error: Invalid menu choice");
        }
    }
}
