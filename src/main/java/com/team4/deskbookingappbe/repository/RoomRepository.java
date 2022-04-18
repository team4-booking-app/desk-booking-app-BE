package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<DtoRoom, Long> {
    List<DtoRoom> findAllByRoomId (Long roomId);
}
