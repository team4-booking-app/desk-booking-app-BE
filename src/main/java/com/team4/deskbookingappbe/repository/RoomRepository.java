package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<DtoRoom, Long> {
}
