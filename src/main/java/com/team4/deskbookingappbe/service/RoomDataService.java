package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomDataService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomDataService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
