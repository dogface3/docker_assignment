import java.util.ArrayList;
import java.util.List;

public class SportsTracker {

    // Inner class to represent a sports activity
    static class SportsActivity {
        String name;
        int duration;  // in minutes
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
    private final List<SportsActivity> activities;

    // Constructor to initialize the tracker
    public SportsTracker() {
        activities = new ArrayList<>();
    }

    public List<SportsActivity> getActivities() {
        return activities;
    }

    // 1. Method to log a new activity
    public void logActivity(String name, int duration, String day) {
        SportsActivity activity = new SportsActivity(name, duration, day);
        activities.add(activity);
        System.out.println("Activity logged successfully!");
    }

    // 2. Method to view all logged activities
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

    // 3. Method to calculate total time spent on sports in the week (in hours and minutes)
    public void calculateTotalTime() {
        int totalMinutes = 0;
        for (SportsActivity activity : activities) {
            totalMinutes += activity.duration;
        }
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        System.out.println("Total time spent on sports this week: " + hours + " hours and " + minutes + " minutes.");
    }
}
