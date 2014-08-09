package drugExpertSystem.substance.Service.substancePropertyService;

import java.util.List;

/**
 * Created by Panupak on 5/31/2014.
 */
public interface SubstancePropService<T extends Object> {
    public void add();
    public T update();
    public T delete();
    public List<T> getAll();
    public T getByID(long id);
    public T getByType(String type);

}
