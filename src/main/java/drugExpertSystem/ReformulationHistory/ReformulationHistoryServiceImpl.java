package drugExpertSystem.ReformulationHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Panupak on 10/11/2014.
 */
@Service
public class ReformulationHistoryServiceImpl implements ReformulationHistoryService {
    @Autowired
    ReformulationHistoryRepository reformulationHistoryRepository;

    @Override
    @Transactional
    public ReformulationHistory createHistory(ReformulationHistory reformulationHistory) {
        try{
            reformulationHistoryRepository.save(reformulationHistory);
        }catch (Exception e){
            return null;
        }
        return reformulationHistory;
    }

    @Override
    @Transactional
    public ReformulationHistory updateHistory(ReformulationHistory reformulationHistory) {
        try{
            reformulationHistoryRepository.save(reformulationHistory);
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    @Transactional
    public ReformulationHistory removeHistory(String id) {
        try{
            reformulationHistoryRepository.delete(getHistoryById(id));
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    @Transactional
    public List<ReformulationHistory> getAllHistory() {
        return reformulationHistoryRepository.findAll();
    }

    @Override
    public ReformulationHistory getHistoryById(String id) {
        return reformulationHistoryRepository.findOne(id);
    }
}
