import java.util.Scanner;

class Classroom {
    private int roomNumber;
    private int capacity;
    private boolean available;

    public Classroom(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void reserveRoom() {
        available = false;
    }

    public void releaseRoom() {
        available = true;
    }
}

public class SchoolRoomReservation {
    private static Classroom[] classrooms = new Classroom[10];
    private static int numberOfClassrooms = 0;

    public static void addClassroom(int roomNumber, int capacity) {
        if (numberOfClassrooms < classrooms.length) {
            classrooms[numberOfClassrooms] = new Classroom(roomNumber, capacity);
            numberOfClassrooms++;
            System.out.println("New classroom added: Room " + roomNumber + " (Capacity: " + capacity + ")");
        } else {
            System.out.println("The added classroom exceeds the maximum limit. Classroom not added.");
        }
    }

    public static void reserveClassroom(int roomNumber, String date, String time) {
        for (int i = 0; i < numberOfClassrooms; i++) {
            if (classrooms[i].getRoomNumber() == roomNumber) {
                if (classrooms[i].isAvailable()) {
                    classrooms[i].reserveRoom();
                    System.out.println("Successfully reserved Room " + roomNumber + " on " + date + " at " + time);
                } else {
                    System.out.println("Room " + roomNumber + " is already occupied at the specified time.");
                }
                return;
            }
        }
        System.out.println("Classroom with room number " + roomNumber + " not found.");
    }

    public static void checkClassroomAvailability(int roomNumber, String date, String time) {
        for (int i = 0; i < numberOfClassrooms; i++) {
            if (classrooms[i].getRoomNumber() == roomNumber) {
                if (classrooms[i].isAvailable()) {
                    System.out.println("Room " + roomNumber + " is available on " + date + " at " + time);
                } else {
                    System.out.println("Room " + roomNumber + " is occupied on " + date + " at " + time);
                }
                return;
            }
        }
        System.out.println("Classroom with room number " + roomNumber + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWELCOME TO THE CLASSROOM RESERVATION PROGRAM");
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new classroom");
            System.out.println("2. Reserve a classroom");
            System.out.println("3. Check classroom availability");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the room number for the new classroom:");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Enter the capacity of the classroom:");
                    int capacity = scanner.nextInt();
                    addClassroom(roomNumber, capacity);
                    break;
                case 2:
                    System.out.println("Enter the room number of the classroom you want to reserve:");
                    roomNumber = scanner.nextInt();
                    System.out.println("Enter the date (dd/mm/yyyy):");
                    String date = scanner.next();
                    System.out.println("Enter the time (hh:mm):");
                    String time = scanner.next();
                    reserveClassroom(roomNumber, date, time);
                    break;
                case 3:
                    System.out.println("Enter the room number of the classroom you want to check:");
                    roomNumber = scanner.nextInt();
                    System.out.println("Enter the date (dd/mm/yyyy):");
                    date = scanner.next();
                    System.out.println("Enter the time (hh:mm):");
                    time = scanner.next();
                    checkClassroomAvailability(roomNumber, date, time);
                    break;
                case 4:
                    System.out.println("Thank you for using the program. Author: Natalia Bednarek");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}