import java.util.PriorityQueue;
import java.util.Scanner;

public class Event {

    private enum EVENT {ENTER, SERVED}

    private PriorityQueue<Student> queue;
    // Priority Queue to keep track of students to serve

    // Constructor
    public Event(int events) {
        queue = new PriorityQueue<>(events, (s1, s2) -> {

            if (s1.getCgpa() == s2.getCgpa()) {
                if (s1.getName().equals(s2.getName())) {
                    return Integer.compare(s1.getToken(), s2.getToken());
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            } else {
                return Float.compare(s2.getCgpa(), s1.getCgpa());
            }
        });
    }

    /*
     * Function to execute events in priority queue */
    private void executeEvent(int events) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= events; i++) {
            String event = sc.nextLine();
            String[] eventDetails = event.split(" ");
            if (eventDetails[0].equals(Event.EVENT.ENTER.name())) {
                String name = eventDetails[1];
                float cgpa = Float.parseFloat(eventDetails[2]);
                int token = Integer.parseInt(eventDetails[3]);
                queue.add(new Student(name, cgpa, token));
            } else if (eventDetails[0].equals(EVENT.SERVED.name()) && queue.peek() != null) {
                queue.remove();
            }
        }
    }

    /*
     * Function to display events after completion of events */
    private void displayQueue() {
        if (!queue.isEmpty()) {
            while (!queue.isEmpty())
                System.out.println(queue.remove().getName());
        } else
            System.out.println("EMPTY");

    }

    /*
     * Main function to instantiate Event class and execute events */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int events = sc.nextInt();
        Event event = new Event(events);
        event.executeEvent(events);
        event.displayQueue();
    }
}
