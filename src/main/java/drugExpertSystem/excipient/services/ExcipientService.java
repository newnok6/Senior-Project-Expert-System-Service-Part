package drugExpertSystem.excipient.services;

import drugExpertSystem.excipient.Excipient;

import java.util.List;

/**
 * Created by Panupak on 9/24/2014.
 */
public interface ExcipientService<T extends Excipient> {
    public T addExcipient(T t);
    public T updateExcipient(T t);
    public T deleteExcipient(T t);
    public List<T> getAllExcipient();
    public T getExcipientById(long id);

}
