/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents the information of time.
 */
public class Clock extends Thread {
    protected int time;

    /**
     * Gets the current time.
     * @return returns current time.
     */
    public int getTime() {
        return time;
    }
}

/**
 * Handles the passage of time.
 */
class TimeCalculationThread extends Clock {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
