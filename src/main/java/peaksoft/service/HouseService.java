package peaksoft.service;

import peaksoft.entity.House;

import java.util.List;

public interface HouseService {
    void saveHouse(Long agencyId, House house);
    House getHouseById(Long houseId);
    List<House> getAllHouses(Long agencyId);
    void updateHouse(Long houseId,House house);
    void deleteHouse(Long houseId);
}
