import java.util.Scanner;

public class Hotel {

    public static void display(HotelRoom... rooms) {
        for (HotelRoom r : rooms) {
            System.out.println(r);
        }
    }

    public static void displaySorted(HotelRoom... rooms) {
        // Bubble sort by room number
        for (int i = 0; i < rooms.length - 1; i++) {
            for (int j = 0; j < rooms.length - 1 - i; j++) {
                if (rooms[j].getRoomNum() > rooms[j + 1].getRoomNum()) {
                    HotelRoom temp = rooms[j];
                    rooms[j] = rooms[j + 1];
                    rooms[j + 1] = temp;
                }
            }
        }
        display(rooms);
    }

    private static HotelRoom findRoomByNumber(int roomNum, HotelRoom... rooms) {
        for (HotelRoom r : rooms) {
            if (r.getRoomNum() == roomNum) {
                return r;
            }
        }
        return null;
    }

    public static void checkIn(String guest, int roomNum, HotelRoom... rooms) {
        HotelRoom r = findRoomByNumber(roomNum, rooms);
        if (r != null && !r.isOccupied()) {
            r.checkIn(guest);
            System.out.println(r);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void checkOut(int roomNum, HotelRoom... rooms) {
        HotelRoom r = findRoomByNumber(roomNum, rooms);
        if (r != null && r.isOccupied()) {
            r.checkOut();
            System.out.println(r);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void findAvailableByBeds(int numBeds, HotelRoom... rooms) {
        boolean found = false;
        for (HotelRoom r : rooms) {
            if (r.getNumBeds() == numBeds && !r.isOccupied()) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available room with the requested number of beds");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        HotelRoom roomA = new HotelRoom(307, 4);
        HotelRoom roomB = new HotelRoom(205, 3);
        HotelRoom roomC = new HotelRoom(402, 2);

        boolean running = true;
        while (running) {
            System.out.println("Hotel Menu:");
            System.out.println("1 - Display rooms by room number (ascending)");
            System.out.println("2 - Check-in");
            System.out.println("3 - Check-out");
            System.out.println("4 - Find room by number of beds");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 0) {
                running = false;
            } else if (choice == 1) {
                displaySorted(roomA, roomB, roomC);
            } else if (choice == 2) {
                System.out.print("Enter room number: ");
                int roomNum = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter guest name: ");
                String guest = scanner.nextLine();
                checkIn(guest, roomNum, roomA, roomB, roomC);
            } else if (choice == 3) {
                System.out.print("Enter room number: ");
                int roomNum = scanner.nextInt();
                checkOut(roomNum, roomA, roomB, roomC);
            } else if (choice == 4) {
                System.out.print("Enter requested number of beds (2-4): ");
                int numBeds = scanner.nextInt();
                findAvailableByBeds(numBeds, roomA, roomB, roomC);
            } else {
                System.out.println("Error: Invalid menu choice");
            }
        }
    }
}
