package arithmeticProgression;

public class ArithmeticProgression {
    private final int initial;
    private final int step;


    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        this.initial = initial;
        this.step = step;
    }

    public int calculate(int n) throws ProgressionConfigurationException {
        int initValue = this.initial;
        int stepValue = this.step;
        ProgressionConfigurationException.progressionConfigurationException(initValue, stepValue);
        return initValue + (n - 1) * stepValue;
    }

    static class ProgressionConfigurationException extends Exception {

        public ProgressionConfigurationException(String message) {
            super(message);
        }


        static void progressionConfigurationException(int initial, int step) throws ProgressionConfigurationException {
            if (initial <= 0 & step == 0) {
                throw new ProgressionConfigurationException("The step value are equal of zero and initial value less or " +
                        "equal of zero!");
            } else if (initial <= 0) {
                throw new ProgressionConfigurationException("The initial value is less or equal of zero!");
            } else if (step == 0) {
                throw new ProgressionConfigurationException("The step value is equal of zero!");
            }
        }
    }
}
