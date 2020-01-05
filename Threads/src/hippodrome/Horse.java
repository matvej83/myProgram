package hippodrome;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Horse implements Runnable {

    private Semaphore semaphore;
    private boolean running = true;
    private String name;
    private int speed = getRandomInt(0, 100);
    private boolean isFinished = false;

    public Horse(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        long timeWorkCode = System.currentTimeMillis() - Program.start;
        System.out.println("Thread start at " + timeWorkCode);
        int distance = 0;
        int maxDistance = 1000;
        try {
            semaphore.acquire();
            while (running) {
                if (distance < maxDistance) {
                    distance += speed;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    isFinished = true;
                    stopThread();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void stopThread() {
        System.out.println("Stopping execution");
        running = false;
        long timeEndCode = System.currentTimeMillis() - Program.start;
        System.out.println("Thread stopped at " + timeEndCode);
    }

    int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
