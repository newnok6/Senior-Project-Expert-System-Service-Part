package drugExpertSystem.substance.DAO.SequeceNumber;

/**
 * Created by Panupak on 5/24/2014.
 */
public interface SequenceDao {
    long getNextSequenceId(String key) throws SequenceException;
}
