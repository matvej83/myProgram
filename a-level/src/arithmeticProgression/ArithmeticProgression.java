package arithmeticProgression;

public class ArithmeticProgression {
    private final int initial;
    private final int step;


    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        this.initial = initial;
        this.step = step;
    }

    public int calculate(int n) throws ProgressionConfigurationException {
        if (this.initial == 0 | this.step ==0) {
            throw new ProgressionConfigurationException();
        }
        return this.initial + (n - 1) * this.step;
    }

    static class ProgressionConfigurationException extends Exception {

        public ProgressionConfigurationException() {
        }

        public ProgressionConfigurationException(String message) {
            super(message);
        }

        public ProgressionConfigurationException(String message, Throwable cause) {
            super(message, cause);
        }

        public ProgressionConfigurationException(Throwable cause) {
            super(cause);
        }

        public ProgressionConfigurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }

        void progressionConfigurationException(int initial, int step) {
            if (initial ==0){
                //getMessage("The initial value is equal zero!");
            }
            if (step ==0){
                getMessage();
            }
        }
    }
}
