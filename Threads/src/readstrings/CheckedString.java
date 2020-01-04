package readstrings;

import java.util.Objects;

public class CheckedString {


    public CheckedString() {

    }

    public boolean hasChanged(String oldString, String newString) {
        boolean haschanged;
        if (Objects.equals(oldString, newString)) {
            haschanged = false;
        } else haschanged = true;
        return haschanged;
    }

}
