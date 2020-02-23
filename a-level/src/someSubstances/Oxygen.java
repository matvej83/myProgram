package someSubstances;

public class Oxygen implements Substance {
    private String Name = "Oxygen";
    private double temperature = 20d;
    private someSubstances.State currentState;

    public Oxygen(double temperature, State currentState) {
        this.temperature = temperature;
        this.currentState = currentState;
    }

    public String getName() {
        return this.Name = Name;
    }

    @Override
    public State heatUp(double t) {
        this.temperature = getTemperature() + t;
        if (this.temperature <= -218.8d) {
            currentState = State.solid;
        } else if (this.temperature >= -218.8d && this.temperature < -183d) {
            currentState = State.liquid;
        } else if (this.temperature >= -183d) {
            currentState = State.gas;
        }
        return currentState;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
