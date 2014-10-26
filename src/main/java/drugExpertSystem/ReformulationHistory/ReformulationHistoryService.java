package drugExpertSystem.ReformulationHistory;

import java.util.List;

/**
 * Created by Panupak on 10/11/2014.
 */

public interface ReformulationHistoryService {
    public ReformulationHistory createHistory(ReformulationHistory reformulationHistory);
    public ReformulationHistory updateHistory(ReformulationHistory reformulationHistory);
    public ReformulationHistory removeHistory(String id);
    public List<ReformulationHistory> getAllHistory();
    public ReformulationHistory getHistoryById(String id);
}
