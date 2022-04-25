package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.domain.DtoBooking;
import com.team4.deskbookingappbe.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<DtoBooking> fetchBookings(String userEmail) {
        if (userEmail != null) {
            return this.bookingRepository.findAllUserReservations(userEmail);
        } else {
            return this.bookingRepository.findAll();
        }
    }
}