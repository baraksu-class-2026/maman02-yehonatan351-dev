import java.util.Scanner;

public class Hotel {

    // ------------------- Display -------------------
    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;

        // Bubble-sort style swaps for 3 elements
        if (second.before(first)) {
            HotelRoom temp = first;
            first = second;
            second = temp;
        }
        if (third.before(second)) {
            HotelRoom temp = second;
            second = third;
            third = temp;
        }
        if (second.before(first)) {
            HotelRoom temp = first;
            first = second;
            second = temp;
        }

        display(first, second, third);
    }

    // ------------------- Find Room -------------------
    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom... rooms) {
        for (HotelRoom room : rooms) {
            if (room.getRoomNum() == roomNum) {
                return room;
            }
        }
        return null;
    }

    // ------------------- Check-In -------------------
    public static void checkIn(String guest, int roomNum, HotelRoom... rooms) {
        HotelRoom room = findRoomByNumber(roomNum, rooms);
        if (room != null && !room.isOccupied()) {
            room.checkIn(guest);
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    // ------------------- Check-Out -------------------
    public static void checkOut(int roomNum, HotelRoom... rooms) {
        HotelRoom room = findRoomByNumber(roomNum, rooms);
        if (room != null) {
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    // ------------------- Find Available By Beds -------------------
    public static void findAvailableByBeds(int numBeds, HotelRoom... rooms) {
        if (numBeds < HotelRoom.MIN_NUMBEDS || numBeds > HotelRoom.MAX_NUMBEDS) {
            System.out.println("No available room with the requested number of beds");
            return;
        }

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

    // ------------------- Main -------------------
    public static void main(String[] args) {
        HotelRoom roomA = new HotelRoom(307, 4);
        HotelRoom roomB = new HotelRoom(205, 3);
        HotelRoom roomC = new HotelRoom(402, 2);

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Hotel Rooms:");
        display(roomA, roomB, roomC);

        System.out.println("\nHotel Menu:");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in");
        System.out.println("3 - Check-out");
        System.out.println("4 - Find room by number of beds");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                displaySorted(roomA, roomB, roomC);
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomNum = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter guest name: ");
                String guest = scanner.nextLine();
                checkIn(guest, roomNum, roomA, roomB, roomC);
                break;
            case 3:
                System.out.print("Enter room number: ");
                int outNum = scanner.nextInt();
                checkOut(outNum, roomA, roomB, roomC);
                break;
            case 4:
                System.out.print("Enter requested number of beds ("
                        + HotelRoom.MIN_NUMBEDS + "-" + HotelRoom.MAX_NUMBEDS + "): ");
                int beds = scanner.nextInt();
                findAvailableByBeds(beds, roomA, roomB, roomC);
                break;
            default:
                System.out.println("Error: Invalid menu choice");
                break;
        }
    }
}
