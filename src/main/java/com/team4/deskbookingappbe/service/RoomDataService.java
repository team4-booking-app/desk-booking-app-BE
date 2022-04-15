package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.domain.DtoDesk;
import com.team4.deskbookingappbe.model.domain.DtoRoom;
import com.team4.deskbookingappbe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDataService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomDataService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

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
}
