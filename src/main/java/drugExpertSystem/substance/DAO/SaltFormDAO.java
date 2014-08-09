package drugExpertSystem.substance.DAO;

import drugExpertSystem.substance.Entity.SubstancePackage.SaltForm;

import java.util.List;

/**
 * Created by Panupak on 5/21/2014.
 */
public interface SaltFormDAO {

    public void addSaltForm(SaltForm saltForm);
    public void editSaltForm(SaltForm saltForm);
    public void deleteSaltForm(SaltForm saltForm);
    public SaltForm getSaltForm(long id);
    public List<SaltForm> getAllSaltForm();
    public SaltForm getSaltFormByName();
}
