public class AppProperties {
    @PropertyKeys.PropertyKey("cargo")
    private String cargo;
    @PropertyKeys.PropertyKey("weight")
    private double weight;
    @PropertyKeys.PropertyKey("length")
    private double length;
    @PropertyKeys.PropertyKey("width")
    private double width;
    @PropertyKeys.PropertyKey("height")
    private double height;
    private String address = "some secret place...";

    public AppProperties() {
    }

    public AppProperties(String address) {
        this.address = address;
    }

    public AppProperties(String cargo, double weight, double length, double width, double height, String address) {
        this.cargo = cargo;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.address = address;
    }
}
