package ex1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeTracker {

    private static Lock consoleLock = new ReentrantLock();

    public static void startTrackingTime() {
        Thread timerThread = new Thread(() -> {
            Instant start = Instant.now();

            while (true) {
                Instant now = Instant.now();
                Duration duration = Duration.between(start, now);
                printMessage("Минуло часу: " + duration.getSeconds() + " seconds");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                printMessage("Минуло 5 секунд");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timerThread.start();
        messageThread.start();
    }

    private static void printMessage(String message) {
        consoleLock.lock();
        try {
            System.out.println(message);
        } finally {
            consoleLock.unlock();
        }
    }

}
