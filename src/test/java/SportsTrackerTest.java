
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class SportsTrackerTest {

    private SportsTracker tracker;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        tracker = new SportsTracker();  // Initialize a new SportsTracker before each test
        System.setOut(new PrintStream(outContent));  // Redirect System.out for testing
    }

    @Test
    public void testLogActivity() {
        tracker.logActivity("Running", 30, "Monday");

        List<SportsTracker.SportsActivity> activities = tracker.getActivities();
        assertEquals(1, activities.size());  // Check that one activity was added
        assertEquals("Running", activities.get(0).name);  // Check the activity name
        assertEquals(30, activities.get(0).duration);  // Check the duration
        assertEquals("Monday", activities.get(0).day);  // Check the day
    }

    @Test
    public void testViewActivities() {
        tracker.logActivity("Running", 30, "Monday");
        tracker.logActivity("Swimming", 45, "Wednesday");

        tracker.viewActivities();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Running, Duration: 30 minutes, Day: Monday"));
        assertTrue(output.contains("Swimming, Duration: 45 minutes, Day: Wednesday"));
    }

    @Test
    public void testCalculateTotalTime() {
        tracker.logActivity("Running", 30, "Monday");
        tracker.logActivity("Swimming", 45, "Wednesday");

        tracker.calculateTotalTime();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Total time spent on sports this week: 1 hours and 15 minutes."));
    }

    @Test
    public void testCalculateTotalTimeWithNoActivities() {
        tracker.calculateTotalTime();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Total time spent on sports this week: 0 hours and 0 minutes."));
    }

    @Test
    public void testLogMultipleActivitiesAndRecalculateTotalTime() {
        tracker.logActivity("Tennis", 60, "Sunday");
        tracker.logActivity("Cycling", 90, "Saturday");

        tracker.calculateTotalTime();

        String output = outContent.toString().trim();
        assertTrue(output.contains("Total time spent on sports this week: 2 hours and 30 minutes."));
    }
}
