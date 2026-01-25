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
        System.out.print("Enter your choice : ");
        int choice = reader.nextInt();
        reader.nextLine(); // כדי לקרוא את השורה החדשה אחרי nextInt

        switch (choice) {
            case 1:
                displaySorted(a, b, c);
                break;

            case 2:
                System.out.print("Enter room number: ");
                int roomNumIn = reader.nextInt();
                reader.nextLine(); // קרא שורה חדשה
                System.out.print("Enter guest name: ");
                String guestName = reader.nextLine();
                checkIn(guestName, roomNumIn, a, b, c);
                break;

            case 3:
                System.out.print("Enter room number: ");
                int roomNumOut = reader.nextInt();
                checkOut(roomNumOut, a, b, c);
                break;

            case 4:
                System.out.print("Enter requested number of beds (2-4): ");
                int numBeds = reader.nextInt();
                findAvailableByBeds(numBeds, a, b, c);
                break;

            default:
                System.out.println("Error: Invalid menu choice");
                break;
        }
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom temp;

        if (b.before(a)) {
            temp = a;
            a = b;
            b = temp;
        }

        if (c.before(a)) {
            temp = a;
            a = c;
            c = b;
            b = temp;
        } else if (c.before(b)) {
            temp = b;
            b = c;
            c = temp;
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void checkIn(String guestName, int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);

        if (chosen == null || chosen.isOccupied()) {
            System.out.println("Error: Room not available or not found");
        } else {
            chosen.checkIn(guestName);
            System.out.println(chosen);
        }
    }

    public static void checkOut(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);

        if (chosen == null) {
            System.out.println("Error: Room not available or not found");
        } else {
            chosen.checkOut();
            System.out.println(chosen);
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

        if (chosen == null) {
            System.out.println("No available room with the requested number of beds");
        } else {
            System.out.println(chosen);
        }
    }

    public static HotelRoom findRoomByNumber(int roomNum, HotelRoom a, HotelRoom b, HotelRoom c) {
        if (a.getRoomNum() == roomNum) {
            return a;
        } else if (b.getRoomNum() == roomNum) {
            return b;
        } else if (c.getRoomNum() == roomNum) {
            return c;
        }
        return null;
    }
}
