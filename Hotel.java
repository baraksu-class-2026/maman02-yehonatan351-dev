import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);

        final HotelRoom a = new HotelRoom(307, 4);
        final HotelRoom b = new HotelRoom(205, 3);
        final HotelRoom c = new HotelRoom(402, 2);

        b.checkIn("Guest Test");

        System.out.println("Hotel rooms:");
        display(a, b, c);

        System.out.println("Hotel Menu:");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in to a room");
        System.out.println("3 - Check-out from a room");
        System.out.println("4 - Find available room by requested beds");
        System.out.print("Enter your choice: ");

        int choice = reader.nextInt();
        reader.nextLine();

        switch (choice) {
            case 1:
                displaySorted(a, b, c);
                break;
            case 2:
                System.out.print("Enter room number: ");
                int roomNumCheckIn = reader.nextInt();
                reader.nextLine();
                System.out.print("Enter guest name: ");
                String guestName = reader.nextLine();
                checkIn(guestName, roomNumCheckIn, a, b, c);
                break;
            case 3:
                System.out.print("Enter room number: ");
                int roomNumCheckOut = reader.nextInt();
                checkOut(roomNumCheckOut, a, b, c);
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

        reader.close();
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;

        // מיון מדויק לפי before()
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

        // הדפסה מדויקת לפי הדרישה
        System.out.println("Hotel Rooms by room number:");
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }

    public static void checkIn(String guestName, int roomNum,
                               HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);
        if (chosen != null && !chosen.isOccupied()) {
            chosen.checkIn(guestName);
            System.out.println(chosen.toString());
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void checkOut(int roomNum,
                                HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = findRoomByNumber(roomNum, a, b, c);
        if (chosen != null) {
            chosen.checkOut();
            System.out.println(chosen.toString());
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void findAvailableByBeds(int beds,
                                           HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom chosen = null;

        if (a.getNumBeds() == beds && !a.isOccupied()) {
            chosen = a;
        } else if (b.getNumBeds() == beds && !b.isOccupied()) {
            chosen = b;
        } else if (c.getNumBeds() == beds && !c.isOccupied()) {
            chosen = c;
        }

        if (chosen != null) {
            System.out.println(chosen.toString());
        } else {
            System.out.println("No available room with the requested number of beds");
        }
    }

    public static HotelRoom findRoomByNumber(int roomNum,
                                             HotelRoom a, HotelRoom b, HotelRoom c) {
        if (a.getRoomNum() == roomNum) {
            return a;
        } else if (b.getRoomNum() == roomNum) {
            return b;
        } else if (c.getRoomNum() == roomNum) {
            return c;
        }
        return null;
    }

    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
