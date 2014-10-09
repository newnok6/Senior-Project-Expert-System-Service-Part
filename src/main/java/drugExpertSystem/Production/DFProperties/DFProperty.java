package drugExpertSystem.Production.DFProperties;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 10/8/2014.
 */

public class DFProperty {
    float totalweight;
    int disgradationtime;
    float hardness;
    List<Double> dissolutionProfile;

    public double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(float totalweight) {
        this.totalweight = totalweight;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public int getDisgradationtime() {
        return disgradationtime;
    }

    public void setDisgradationtime(int disgradationtime) {
        this.disgradationtime = disgradationtime;
    }

    public double getHardness() {
        return hardness;
    }

    public List<Double> getDissolutionProfile() {
        return dissolutionProfile;
    }

    public void setDissolutionProfile(List<Double> dissolutionProfile) {
        this.dissolutionProfile = dissolutionProfile;
    }

}
