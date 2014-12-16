package drugExpertSystem.Production.DFProperties;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Panupak on 10/8/2014.
 */

public class DFProperty {
    double totalweight;
    int disgradationtime;
    double hardness;
    List<Double> dissolutionProfile;

    public double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(double totalweight) {
        this.totalweight = totalweight;
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

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public List<Double> getDissolutionProfile() {
        return dissolutionProfile;
    }

    public void setDissolutionProfile(List<Double> dissolutionProfile) {
        this.dissolutionProfile = dissolutionProfile;
    }
}


