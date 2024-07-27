package com.Teamairlines.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Teamairlines.flightManagementSystem.bean.DailySeatBooking;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailySeatBookingRepository extends JpaRepository<DailySeatBooking, Long> {
	 DailySeatBooking findBookingByTicketNumber(Long ticketNumber);
    @Query("select d from DailySeatBooking d where d.flightNumber = :flightNumber and d.bookingDate = :bookingDate")
    DailySeatBooking findBookingByFlightNumberAndDate(@Param("flightNumber") Long flightNumber, @Param("bookingDate") LocalDate bookingDate);

    @Query("select d from DailySeatBooking d where d.flightNumber = :flightNumber")
    List<DailySeatBooking> findBookingsByFlightNumber(@Param("flightNumber") Long flightNumber);

    @Query("select d from DailySeatBooking d where d.bookingDate = :bookingDate")
    List<DailySeatBooking> findBookingsByDate(@Param("bookingDate") LocalDate bookingDate);

    @Query("select d from DailySeatBooking d where d.ticketNumber = :ticketNumber and d.bookingDate = :bookingDate")
    DailySeatBooking findBookingByTicketNumberAndDate(@Param("ticketNumber") Long ticketNumber, @Param("bookingDate") LocalDate bookingDate);
}
