package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public DtoReservations createReservation(CreateReservationsRequest request){
        DtoReservations reservation = DtoReservations.builder()
                .userEmail(request.getUserEmail())
                .deskId(request.getDeskId())
                .reservationStart(Timestamp.valueOf(request.getReservationStart()))
                .reservationEnd(Timestamp.valueOf(request.getReservationEnd()))
                .build();

        return reservationsRepository.save(reservation);
    }

    public List<DtoReservations> fetchReservations(Long reservationId, String userEmail, Long deskId, String reservationStart, String reservationEnd){
        if(reservationId != null){
            return this.reservationsRepository.findAllByReservationId(reservationId);
        }
        else if(userEmail != null){
            return this.reservationsRepository.findAllByUserEmail(userEmail);
        }
        else if(deskId != null){
            return this.reservationsRepository.findAllByDeskId(deskId);
        }
        else if(reservationStart != null && reservationStart != null){
            return this.reservationsRepository.findAllByReservationStartAndReservationEndWhereIntersectsBetween(reservationStart,reservationEnd);
        }
        else{
            return this.reservationsRepository.findAll();
        }
    }

    public void deleteReservation(Long reservationId){
        reservationsRepository.deleteById(reservationId);
    }
}
