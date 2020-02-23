package someSubstances;

public class Iron implements Substance {
    private String Name = "Iron";
    private double temperature = 20d;
    private someSubstances.State currentState;

    public Iron(double temperature, State currentState) {
        this.temperature = temperature;
        this.currentState = currentState;
    }

    public String getName() {
        return this.Name = Name;
    }

    @Override
    public State heatUp(double t) {
        this.temperature = getTemperature() + t;
        if (this.temperature <= 1538d) {
            currentState = State.solid;
        } else if (this.temperature >= 1538d && this.temperature < 2862d) {
            currentState = State.liquid;
        } else if (this.temperature >= 2862d) {
            currentState = State.gas;
        }
        return currentState;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
