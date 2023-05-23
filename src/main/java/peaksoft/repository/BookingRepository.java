package peaksoft.repository;

import peaksoft.entity.Agency;
import peaksoft.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);
    Agency getBookingById(Long bookingId);
    List<Booking> getAllBooking();
    void updateBooking(Long bookingId,Booking booking);
    void deleteBooking(Long bookingId);
}
