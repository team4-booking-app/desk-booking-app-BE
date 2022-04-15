package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.model.domain.DtoRoom;
import com.team4.deskbookingappbe.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsDataService {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsDataService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public DtoReservations createReservation(CreateReservationsRequest request){
        DtoReservations reservation = DtoReservations.builder()
                .userEmail(request.getUserEmail())
                .deskId(request.getDeskId())
                .reservationStart(request.getReservationStart())
                .reservationEnd(request.getReservationEnd())
                .build();

        return reservationsRepository.save(reservation);
    }

    public List<DtoReservations> fetchReservations(Long id){
        return reservationsRepository.findAll();
    }

    public void deleteReservation(Long id){
        reservationsRepository.deleteById(id);
    }
}
