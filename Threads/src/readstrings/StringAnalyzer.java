package readstrings;

import java.util.Objects;

public class StringAnalyzer extends Thread {

    private boolean running = true;
    private String oldString;
    private String newString = "";
    private String fileName;

    @Override
    public void run() {

        CheckedString checkedString = new CheckedString();
        IOtoFile iOtoFile = new IOtoFile();

        while (running) {
            oldString = iOtoFile.inputStringFromFile(fileName);
            if (Objects.equals(newString, "")) {
                newString = oldString;
            }
            if (checkedString.hasChanged(oldString, newString) && !Objects.equals(newString, "quit")) {
                iOtoFile.outputStringToFile(newString, fileName);
                System.out.println("Because " + oldString + " not equals " + newString + " we've write data.");
                System.out.println("Data wrote successful!");
            }
        }

        System.out.println("Execution stopped");
    }

    public void stopThread() {
        System.out.println("Stopping execution");
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getOldString() {
        return oldString;
    }

    public void setOldString(String oldString) {
        this.oldString = oldString;
    }

    public String getNewString() {
        return newString;
    }

    public void setNewString(String newString) {
        this.newString = newString;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
