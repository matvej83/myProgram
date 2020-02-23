package hippodrome;

import java.util.concurrent.ConcurrentHashMap;

public class Race {

    private ConcurrentHashMap<String, Integer> hasFinished = new ConcurrentHashMap<>();

    public Race() {
    }

    public ConcurrentHashMap<String, Integer> getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(ConcurrentHashMap<String, Integer> hasFinished) {
        this.hasFinished = hasFinished;
    }

    public void addFinished(String horseName) {
        int position = this.hasFinished.size();
        this.hasFinished.put(horseName, position + 1);
    }
}
