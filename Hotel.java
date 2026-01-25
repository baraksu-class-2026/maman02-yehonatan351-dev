import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);

        final HotelRoom a = new HotelRoom(307, 4);
        final HotelRoom b = new HotelRoom(205, 3);
        final HotelRoom c = new HotelRoom(402, 2);

        b.checkIn("Guest Test");

        System.out.println("\nHotel Menu :");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in to a room");
        System.out.println("3 - Check-out from a room");
        System.out.println("4 - Find available room by requested beds");
        System.out.print("Enter your choice: ");

        int choice = reader.nextInt();
        reader.nextLine(); // לוקח את השורה הנותרת

        switch (choice) {
            case 1: {
                displaySorted(a, b, c);
                break;
            }

            case 2: {
                System.out.print("Enter room number: ");
                int roomNumCheckIn = reader.nextInt();
                reader.nextLine();
                System.out.print("Enter guest name: ");
                String guestName = reader.nextLine();
                checkIn(guestName, roomNumCheckIn, a, b, c);
                break;
            }

            case 3: {
                System.out.print("Enter room number: ");
                int roomNumCheckOut = reader.nextInt();
                checkOut(roomNumCheckOut, a, b, c);
                break;
            }

            case 4: {
                System.out.print("Enter requested number of beds (2-4): ");
                int numBeds = reader.nextInt();
                findAvailableByBeds(numBeds, a, b, c);
                break;
            }

            default: {
                System.out.println("Error: Invalid menu choice");
            }
        }

        reader.close();
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        if (b.before(a)) {
            swapRooms(a, b);
        }
        if (c.before(a)) {
            swapRooms(a, c);
        }
        if (c.before(b)) {
            swapRooms(b, c);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private static void swapRooms(HotelRoom r1, HotelRoom r2) {
        final int tempRoomNum = r1.getRoomNum();
        final int tempBeds = r1.getNumBeds();
        final boolean tempOccupied = r1.isOccupied();
        final String tempGuest = r1.getGuest();

        // מחליפים את r1
        r1.setRoomNum(r2.getRoomNum());
        r1.setNumBeds(r2.getNumBeds());
        if (r2.isOccupied()) {
            r1.checkIn(r2.getGuest());
        } else {
            r1.checkOut();
        }

        // מחליפים את r2
        r2.setRoomNum(tempRoomNum);
        r2.setNumBeds(tempBeds);
        if (tempOccupied) {
            r2.checkIn(tempGuest);
        } else {
            r2.checkOut();
        }
    }

    public static void checkIn(String guestName, int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        final HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);
        if (chosen != null && !chosen.isOccupied()) {
            chosen.checkIn(guestName);
            System.out.println(chosen);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        final HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);
        if (chosen != null) {
            chosen.checkOut();
            System.out.println(chosen);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void findAvailableByBeds(int beds, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = null;
        if (a.getNumBeds() == beds && !a.isOccupied()) {
            chosen = a;
        } else if (b.getNumBeds() == beds && !b.isOccupied()) {
            chosen = b;
        } else if (c.getNumBeds() == beds && !c.isOccupied()) {
            chosen = c;
        }

        if (chosen != null) {
            System.out.println(chosen);
        } else {
            System.out.println("No available room with the requested number of beds");
        }
    }

    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
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
}
