package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.repository.AgencyRepository;
import peaksoft.service.AgencyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Override
    public void saveAgency(Agency agency) throws MyException {
        agencyRepository.saveAgency(agency);
    }

    @Override
    public Agency getAgencyById(Long agencyId) throws MyException {
        return agencyRepository.getAgencyById(agencyId);
    }

    @Override
    public List<Agency> getAllAgency() {
        return agencyRepository.getAllAgency();
    }

    @Override
    public void updateAgency(Long agencyId, Agency agency) {
        agencyRepository.updateAgency(agencyId,agency);
    }

    @Override
    public void deleteAgency(Long agencyId) {
        agencyRepository.deleteAgency(agencyId);
    }
}
