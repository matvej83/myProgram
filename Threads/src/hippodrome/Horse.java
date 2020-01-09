package hippodrome;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Horse implements Runnable {

    private CountDownLatch countDownLatch;
    private boolean running = true;
    private String name;
    private int speed = getRandomInt(60, 100);

    public Horse(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        int distance = 0;
        int maxDistance = 1000;
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
            countDownLatch.countDown();
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
        Race.addFinished(Thread.currentThread().getName());
        running = false;
    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
