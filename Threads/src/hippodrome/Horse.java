package hippodrome;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Horse implements Runnable {

    private Semaphore semaphore;
    private boolean running = true;
    private String name;
    private int speed = getRandomInt(60, 100);

    public Horse(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
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
        Program.addFinished(Thread.currentThread().getName());
        running = false;
    }

    int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
