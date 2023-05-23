package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.repository.AgencyRepository;
import peaksoft.repository.HouseRepository;

import java.util.List;
@Repository
@Transactional
public class HouseRepositoryImpl implements HouseRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    private final AgencyRepository agencyRepository;

    @Autowired
    public HouseRepositoryImpl(EntityManager entityManager, AgencyRepository agencyRepository) {
        this.entityManager = entityManager;
        this.agencyRepository = agencyRepository;
    }


    @Override
    public void saveHouse(Long agencyId, House house) {
        Agency agency = entityManager.find(Agency.class, agencyId);
        agency.addHouse(house);
        house.setAgency(agency);
        entityManager.persist(house);
    }

    @Override
    public House getHouseById(Long houseId) {
        return entityManager.find(House.class, houseId);
    }

    @Override
    public List<House> getAllHouses(Long agencyId) {
        return entityManager.createQuery
                ("select h from House h join h.agency a where a.id = :agencyId",
                        House.class).setParameter("agencyId", agencyId).getResultList();
    }

    @Override
    public void updateHouse(Long houseId, House house) {
        House h = entityManager.find(House.class, houseId);
        h.setHouseType(house.getHouseType());
        h.setAddress(house.getAddress());
        h.setPrice(house.getPrice());
        h.setRoom(house.getRoom());
        h.setCountry(house.getCountry());
        h.setDescription(house.getDescription());
        h.setIsBooked(house.getIsBooked());
        h.setImage(house.getImage());
        entityManager.merge(h);
    }

    @Override
    public void deleteHouse(Long houseId) {
        House house = entityManager.find(House.class, houseId);
        house.setAgency(null);
    }
}
