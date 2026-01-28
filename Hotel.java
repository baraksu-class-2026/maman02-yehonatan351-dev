import java.util.Scanner;

public class Hotel {

    // --- Display rooms sorted by room number ---
    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;

        // Bubble sort for 3 rooms
        if (second.getRoomNum() < first.getRoomNum()) {
            HotelRoom temp = first;
            first = second;
            second = temp;
        }
        if (third.getRoomNum() < second.getRoomNum()) {
            HotelRoom temp = second;
            second = third;
            third = temp;
        }
        if (second.getRoomNum() < first.getRoomNum()) {
            HotelRoom temp = first;
            first = second;
            second = temp;
        }

        display(first, second, third);
    }

    // --- Display rooms ---
    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    // --- Check-in ---
    public static void checkIn(String guest, int roomNum, HotelRoom a, HotelRoom b,
                               HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null && !room.isOccupied()) {
            room.checkIn(guest);
            System.out.println("Room " + room.getRoomNum() + ": Occupied by " + guest);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    // --- Check-out ---
    public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null && room.isOccupied()) {
            room.checkOut();
            System.out.println("Room " + room.getRoomNum() + ": Available");
        } else if (room != null) {
            System.out.println("Room " + room.getRoomNum() + " is already available");
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    // --- Find available room by number of beds ---
    public static void findAvailableByBeds(int numBeds, HotelRoom a, HotelRoom b,
                                           HotelRoom c) {
        if (numBeds < HotelRoom.MIN_NUMBEDS || numBeds > HotelRoom.MAX_NUMBEDS) {
            System.out.println("No available room with the requested number of beds");
            return;
        }

        HotelRoom[] rooms = {a, b, c};
        boolean found = false;

        for (HotelRoom room : rooms) {
            if (!room.isOccupied() && room.getNumBeds() == numBeds) {
                System.out.println("Room " + room.getRoomNum() + ": " + room.getNumBeds()
                                   + " Beds");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available room with the requested number of beds");
        }
    }

    // --- Find room by number ---
    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b,
                                             HotelRoom c) {
        if (a.getRoomNum() == roomNum) {
            return a;
        }
        if (b.getRoomNum() == roomNum) {
            return b;
        }
        if (c.getRoomNum() == roomNum) {
            return c;
        }
        return null;
    }

    // --- Main method ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HotelRoom roomA = new HotelRoom(307, 4);
        HotelRoom roomB = new HotelRoom(205, 3);
        HotelRoom roomC = new HotelRoom(402, 2);

        System.out.println("Hotel Rooms:");
        display(roomA, roomB, roomC);

        System.out.println("\nHotel Menu:");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in");
        System.out.println("3 - Check-out");
        System.out.println("4 - Find available room by number of beds");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            displaySorted(roomA, roomB, roomC);
        } else if (choice == 2) {
            System.out.print("Enter room number: ");
            int roomNum = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter guest name: ");
            String guest = scanner.nextLine();
            checkIn(guest, roomNum, roomA, roomB, roomC);
        } else if (choice == 3) {
            System.out.print("Enter room number: ");
            int roomNum = scanner.nextInt();
            checkOut(roomNum, roomA, roomB, roomC);
        } else if (choice == 4) {
            System.out.print("Enter requested number of beds ("
                             + HotelRoom.MIN_NUMBEDS + "-" + HotelRoom.MAX_NUMBEDS + "): ");
            int beds = scanner.nextInt();
            findAvailableByBeds(beds, roomA, roomB, roomC);
        } else {
            System.out.println("Error: Invalid menu choice");
        }
    }
}
