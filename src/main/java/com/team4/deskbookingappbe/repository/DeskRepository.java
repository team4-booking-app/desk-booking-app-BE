package com.team4.deskbookingappbe.repository;

import com.team4.deskbookingappbe.model.domain.DtoDesk;
import com.team4.deskbookingappbe.model.domain.DtoReservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeskRepository extends JpaRepository<DtoDesk,Long> {
    List<DtoDesk> findAllByDeskId (Long deskId);
}
