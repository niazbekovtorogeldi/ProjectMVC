package peaksoft.repository.impl;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Booking;
import peaksoft.repository.BookingRepository;

import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;
    @Autowired
    public BookingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveBooking(Booking booking) {

    }

    @Override
    public Agency getBookingById(Long bookingId) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }

    @Override
    public void updateBooking(Long bookingId, Booking booking) {

    }

    @Override
    public void deleteBooking(Long bookingId) {

    }
}
