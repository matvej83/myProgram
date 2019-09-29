package someSubstances;

public class Water implements Substance {
    private String Name = "Water";
    private double temperature = 20d;
    private someSubstances.State currentState;

    Water(double temperature, someSubstances.State currentState) {
        this.temperature = temperature;
        this.currentState = currentState;
    }

    public String getName() {
        return this.Name = Name;
    }

    @Override
    public State heatUp(double t) {
        this.temperature = getTemperature() + t;
        if (this.temperature <= 0) {
            currentState = State.SOLID;
        } else if (this.temperature >= 0 && this.temperature < 100d) {
            currentState = State.LIQUID;
        } else if (this.temperature >= 100d) {
            currentState = State.GAS;
        }
        return currentState;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
