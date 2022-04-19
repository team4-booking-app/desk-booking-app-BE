package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.domain.DtoDesk;
import com.team4.deskbookingappbe.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {

    private final DeskRepository deskRepository;

    @Autowired
    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    public DtoDesk createDesk(CreateDeskRequest request){
        DtoDesk desk = DtoDesk.builder()
                .deskName(request.getDeskName())
                .roomId(request.getRoomId())
                .build();

        return deskRepository.save(desk);
    }

    public List<DtoDesk> fetchDesks(Long deskId){
        if(deskId != null){
            return this.deskRepository.findAllByDeskId(deskId);
        }
        else {
            return deskRepository.findAll();
        }
    }

    public void deleteDesk(Long deskId){
        deskRepository.deleteById(deskId);
    }
}
