package annotations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    @PropertyKey(cargo = "", weight = 0.0, length = 0.0, width = 0.0, height = 0.0)
    public String cargo;
    public double weight;
    public double length;
    public double width;
    public double height;
    public String address;

    public AppProperties() {
        address = "some secret place...";
        Properties props = new Properties();
        String proppath = "src\\annotations\\app.properties.txt";
        try (FileInputStream fs = new FileInputStream(new File(proppath))) {
            props.load(fs);
            cargo = props.getProperty("aCargo");
            weight = Double.parseDouble(props.getProperty("aWeight"));
            length = Double.parseDouble(props.getProperty("aLength"));
            width = Double.parseDouble(props.getProperty("aWidth"));
            height = Double.parseDouble(props.getProperty("aHeight"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        AppProperties appProperties = new AppProperties();
        System.out.println("Cargo type: " + appProperties.cargo);
        System.out.println("Weight, kg: " + appProperties.weight);
        System.out.println("Length, mm: " + appProperties.length);
        System.out.println("Width, mm: " + appProperties.width);
        System.out.println("Height, mm: " + appProperties.height);
        System.out.println("Address: " + appProperties.address);
    }
}
