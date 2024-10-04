public class SportsTrackerTest {

    public static void main(String[] args) {
        SportsTracker tracker = new SportsTracker();

        // Test 1: Log a few activities
        System.out.println("Test 1: Log activities");
        tracker.logActivity("Running", 30, "Monday");
        tracker.logActivity("Swimming", 45, "Wednesday");
        tracker.logActivity("Cycling", 60, "Friday");
        tracker.logActivity("Yoga", 40, "Saturday");

        // Test 2: View all logged activities
        System.out.println("\nTest 2: View activities");
        tracker.viewActivities();  // This should print all the logged activities

        // Test 3: Calculate total time spent on sports for the week
        System.out.println("\nTest 3: Calculate total time");
        tracker.calculateTotalTime();  // This should calculate and display total time

        // Test 4: Log more activities and calculate again
        System.out.println("\nTest 4: Log more activities and recalculate");
        tracker.logActivity("Tennis", 90, "Sunday");
        tracker.logActivity("Basketball", 60, "Thursday");
        tracker.calculateTotalTime();  // Updated total time with more activities

        // Test 5: View activities after adding more
        System.out.println("\nTest 5: View activities after more entries");
        tracker.viewActivities();  // Ensure that all activities are correctly displayed
    }
}
