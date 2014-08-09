package drugExpertSystem.substance.DAO.SequeceNumber;

/**
 * Created by Panupak on 5/24/2014.
 */
public class SequenceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    //get, set...
    public SequenceException(String errMsg) {
        this.errMsg = errMsg;
    }
}
