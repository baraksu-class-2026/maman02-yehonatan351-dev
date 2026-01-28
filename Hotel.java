import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);

        final HotelRoom room1 = new HotelRoom(307, 4);
        final HotelRoom room2 = new HotelRoom(205, 3);
        final HotelRoom room3 = new HotelRoom(402, 2);

        room2.checkIn("Guest Test");

        System.out.println("\nHotel Menu :");
        System.out.println("1 - Display rooms by room number (ascending)");
        System.out.println("2 - Check-in to a room");
        System.out.println("3 - Check-out from a room");
        System.out.println("4 - Find available room by requested beds");
        System.out.print("Enter your choice: ");

        int choice = reader.nextInt();
        reader.nextLine();

        switch (choice) {
            case 1: {
                displaySorted(room1, room2, room3);
                break;
            }
            case 2: {
                System.out.print("Enter room number: ");
                int roomNumCheckIn = reader.nextInt();
                reader.nextLine();
                System.out.print("Enter guest name: ");
                String guestName = reader.nextLine();
                checkIn(guestName, roomNumCheckIn, room1, room2, room3);
                break;
            }
            case 3: {
                System.out.print("Enter room number: ");
                int roomNumCheckOut = reader.nextInt();
                checkOut(roomNumCheckOut, room1, room2, room3);
                break;
            }
            case 4: {
                System.out.print("Enter requested number of beds (" +
                        HotelRoom.MIN_NUMBEDS + "-" + HotelRoom.MAX_NUMBEDS + "): ");
                int numBeds = reader.nextInt();
                findAvailableByBeds(numBeds, room1, room2, room3);
                break;
            }
            default: {
                System.out.println("Error: Invalid menu choice");
                break;
            }
        }

        reader.close();
    }

    public static void displaySorted(HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom first = a;
        HotelRoom second = b;
        HotelRoom third = c;

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

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static void checkIn(String guestName, int roomNum,
                               HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null && !room.isOccupied()) {
            room.checkIn(guestName);
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void checkOut(int roomNum,
                                HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = findRoomByNumber(roomNum, a, b, c);
        if (room != null) {
            room.checkOut();
            System.out.println(room);
        } else {
            System.out.println("Error: Room not available or not found");
        }
    }

    public static void findAvailableByBeds(int beds,
                                           HotelRoom a, HotelRoom b, HotelRoom c) {
        HotelRoom room = null;
        if (a.getNumBeds() == beds && !a.isOccupied()) {
            room = a;
        } else if (b.getNumBeds() == beds && !b.isOccupied()) {
            room = b;
        } else if (c.getNumBeds() == beds && !c.isOccupied()) {
            room = c;
        }

        if (room != null) {
            System.out.println(room);
        } else {
            System.out.println("No available room with the requested number of beds");
        }
    }

    public static HotelRoom findRoomByNumber(int roomNum,
                                             HotelRoom a, HotelRoom b, HotelRoom c) {
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

    public static void display(HotelRoom a, HotelRoom b, HotelRoom c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
