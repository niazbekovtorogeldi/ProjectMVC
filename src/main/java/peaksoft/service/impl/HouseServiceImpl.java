package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.House;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
   private final  HouseRepository houseRepository;

    @Override
    public void saveHouse(Long agencyId, House house) {
        houseRepository.saveHouse(agencyId, house);
    }

    @Override
    public House getHouseById(Long houseId) {
        return houseRepository.getHouseById(houseId);
    }

    @Override
    public List<House> getAllHouses(Long agencyId) {
        return houseRepository.getAllHouses(agencyId);
    }

    @Override
    public void updateHouse(Long houseId, House house) {
        houseRepository.updateHouse(houseId, house);
    }

    @Override
    public void deleteHouse(Long houseId) {
    houseRepository.deleteHouse(houseId);
    }
}
