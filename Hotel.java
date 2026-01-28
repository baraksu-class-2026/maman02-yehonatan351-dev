import java.util.Scanner;

/**
 * Management class for Hotel operations.
 */
public class Hotel {

    /**
     * Displays rooms details.
     */
    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * Displays rooms sorted by room number.
     */
    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;
        HotelRoom temp;

        if (second.before(first)) {
            temp = first;
            first = second;
            second = temp;
        }
        if (third.before(second)) {
            temp = second;
            second = third;
            third = temp;
        }
        if (second.before(first)) {
            temp = first;
            first = second;
            second = temp;
        }

        display(first, second, third);
    }

    /**
     * Finds a room by its number.
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
     * Handles room check-in.
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
     * Handles room check-out.
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
     * Finds available rooms by bed count.
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
     * Main entry point.
     */
    public static void main(String[] args) {
        HotelRoom r1 = new HotelRoom(307, 4);
        HotelRoom r2 = new HotelRoom(205, 3);
        HotelRoom r3 = new HotelRoom(402, 2);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Hotel Rooms:");
            display(r1, r2, r3);

            System.out.println("\nHotel Menu:");
            System.out.println("1 - Display rooms by room number (ascending)");
            System.out.println("2 - Check-in");
            System.out.println("3 - Check-out");
            System.out.println("4 - Find room by number of beds");

            System.out.print("Enter your choice: ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();
                processChoice(choice, sc, r1, r2, r3);
            }
        }
    }

    private static void processChoice(int choice, Scanner sc, 
                                     HotelRoom r1, HotelRoom r2, HotelRoom r3) {
        switch (choice) {
            case 1:
                displaySorted(r1, r2, r3);
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomNum = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter guest name: ");
                String guest = sc.nextLine();
                checkIn(guest, roomNum, r1, r2, r3);
                break;
            case 3:
                System.out.print("Enter room number: ");
                int outNum = sc.nextInt();
                checkOut(outNum, r1, r2, r3);
                break;
            case 4:
                System.out.print("Enter requested number of beds: ");
                int beds = sc.nextInt();
                findAvailableByBeds(beds, r1, r2, r3);
                break;
            default:
                System.out.println("Error: Invalid menu choice");
        }
    }
}
