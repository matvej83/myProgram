package hippodrome;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Horse implements Runnable {

    private CountDownLatch countDownLatch;
    private boolean running;
    private String name;
    private int speed = getRandomInt(60, 100);
    private String filePath;

    public Horse(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public void run() {
        int distance = 0;
        int maxDistance = 1000;
        running = true;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void stopThread() {
        IOtoFile writeToFile = new IOtoFile();
        writeToFile.writeStringToFile(Thread.currentThread().getName(), getFilePath());
        running = false;
    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return name.equals(horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}