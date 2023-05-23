package peaksoft.service;

import peaksoft.entity.Agency;
import peaksoft.exception.MyException;

import java.util.List;

public interface AgencyService {

    void saveAgency(Agency agency) throws MyException;
    Agency getAgencyById(Long agencyId) throws MyException;
    List<Agency> getAllAgency();
    void updateAgency(Long agencyId,Agency agency);
    void deleteAgency(Long agencyId);
}
