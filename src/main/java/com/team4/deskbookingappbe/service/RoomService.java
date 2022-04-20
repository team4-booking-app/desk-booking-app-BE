package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateRoomRequest;
import com.team4.deskbookingappbe.model.domain.DtoRoom;
import com.team4.deskbookingappbe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public DtoRoom createRoom(CreateRoomRequest request){
        DtoRoom room = DtoRoom.builder()
                .roomName(request.getRoomName())
                .build();

        return roomRepository.save(room);
    }

    public List<DtoRoom> fetchRooms(Long roomId){
        if(roomId != null){
            return roomRepository.findAllByRoomId(roomId);
        }
        else {
            return roomRepository.findAll();
        }
    }

    public void deleteRoom(Long roomId){
        roomRepository.deleteById(roomId);
    }
}
