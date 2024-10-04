import java.util.ArrayList;
import java.util.Scanner;

public class SportsTracker {

    // Inner class to represent a Sports Activity
    static class SportsActivity {
        String name;
        int duration; // in minutes
        String day;

        public SportsActivity(String name, int duration, String day) {
            this.name = name;
            this.duration = duration;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Activity: " + name + ", Duration: " + duration + " minutes, Day: " + day;
        }
    }

    // List to store all logged activities
    private ArrayList<SportsActivity> activities;

    // Constructor to initialize the tracker
    public SportsTracker() {
        activities = new ArrayList<>();
    }

    // Method to log a new activity
    public void logActivity(String name, int duration, String day) {
        SportsActivity activity = new SportsActivity(name, duration, day);
        activities.add(activity);
        System.out.println("Activity logged successfully!");
    }

    // Method to display all logged activities
    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            System.out.println("Logged Activities:");
            for (SportsActivity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    // Method to calculate total time spent on sports in the week
    public void calculateTotalTime() {
        int totalMinutes = 0;
        for (SportsActivity activity : activities) {
            totalMinutes += activity.duration;
        }
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        System.out.println("Total time spent on sports this week: " + hours + " hours and " + minutes + " minutes.");
    }

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SportsTracker tracker = new SportsTracker();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSports Activity Tracker");
            System.out.println("1. Log a new activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent on sports for the week");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter activity name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the day (e.g., Monday, Tuesday): ");
                    String day = scanner.nextLine();
                    tracker.logActivity(name, duration, day);
                    break;
                case 2:
                    tracker.viewActivities();
                    break;
                case 3:
                    tracker.calculateTotalTime();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
