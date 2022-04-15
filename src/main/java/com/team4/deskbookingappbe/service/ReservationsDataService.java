package com.team4.deskbookingappbe.service;

<<<<<<< HEAD
import com.team4.deskbookingappbe.model.api.CreateReservationsRequest;
import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.domain.DtoReservations;
import com.team4.deskbookingappbe.model.domain.DtoRoom;
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
import com.team4.deskbookingappbe.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
@Service
public class ReservationsDataService {

    private final ReservationsRepository reservationsRepository;

    @Autowired
    public ReservationsDataService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }
<<<<<<< HEAD

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
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
}
