package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationsDataService {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsDataService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }
}
