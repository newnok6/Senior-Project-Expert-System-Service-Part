package drugExpertSystem.Production.UnitOperation;

/**
 * Created by Panupak on 8/21/2014.
 */
public class Drying extends UnitOperation {
    String type;
    int temperature;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
