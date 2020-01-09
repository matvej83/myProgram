package hippodrome;

import java.util.concurrent.ConcurrentHashMap;

public class Race {

    private static ConcurrentHashMap<String, Integer> hasFinished = new ConcurrentHashMap<>();

    public Race() {
    }

    public ConcurrentHashMap<String, Integer> getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(ConcurrentHashMap<String, Integer> hasFinished) {
        Race.hasFinished = hasFinished;
    }

    public static void addFinished(String horse) {
        int position = Race.hasFinished.size();
        Race.hasFinished.put(horse, position + 1);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
