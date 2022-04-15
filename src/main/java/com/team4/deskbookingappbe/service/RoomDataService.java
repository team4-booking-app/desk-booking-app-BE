package com.team4.deskbookingappbe.service;

<<<<<<< HEAD
import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.domain.DtoDesk;
import com.team4.deskbookingappbe.model.domain.DtoRoom;
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
import com.team4.deskbookingappbe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
@Service
public class RoomDataService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomDataService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
<<<<<<< HEAD

    public DtoRoom createRoom(CreateRoomRequest request){
        DtoRoom room = DtoRoom.builder()
                .roomName(request.getRoomName())
                .build();

        return roomRepository.save(room);
    }

    public List<DtoRoom> fetchRooms(Long id){
        return roomRepository.findAll();
    }

    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
}
