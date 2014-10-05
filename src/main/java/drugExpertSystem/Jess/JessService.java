package drugExpertSystem.Jess;

import jess.Rete;

/**
 * Created by Panupak on 10/2/2014.
 */
public interface JessService {
    public void addBaseFact();
    public Rete getFact();
}
