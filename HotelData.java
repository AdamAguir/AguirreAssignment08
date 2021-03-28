/**
 *  @Author: Adam Aguirre
 *  @Date: 3/28/21
 *  Assignment 08
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HotelData {

    private HashMap<Integer, Guest> rooms = new HashMap<Integer, Guest>();

    public HotelData() {
        loadData();
    }

    public void loadData() {
        try (Scanner scan = new Scanner(new File("rooms.txt"))) {
            // Iterator<Integer> it = scan.iterator();
            do {
                rooms.put(scan.nextInt(), null);
                // System.out.println(rooms.toString());
            } while (scan.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    public boolean roomExist(int r) {
        boolean found = false;
        for (Integer i : rooms.keySet()) {
            if (i == r) {
                found = true;
            }
        }
        return found;
    }

    public boolean roomAvail(int r) {
        boolean avail = false;
        if (rooms.get(r) == null) {
            avail = true;
        }
        return avail;
    }

    public boolean bookRoom(int r, Guest g) {
        if (roomExist(r)) {
            rooms.put(r, g);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOut(int r) {
        try {
            if (!roomExist(r)) {
                throw new NullPointerException("Room does not exist");
            }
            rooms.put(r, null);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e);
            return false;
        } catch (InputMismatchException e) {
            System.out.println(e);
            return false;

        }

    }

    public String seeAllRooms() {
        return rooms.toString();
    }

    public String seeBookedRooms() {
        StringBuilder bookedRooms = new StringBuilder();
        for (Integer i : rooms.keySet()) {
            if (rooms.get(i) != null) {
                bookedRooms.append(i + "=" + rooms.get(i).toString() + " ");
            }
        }
        if (bookedRooms.isEmpty()) {
            return "***No rooms are currently booked***";
        } else {
            return bookedRooms.toString();
        }
    }

    @Override
    public String toString() {
        return rooms.toString();
    }

}