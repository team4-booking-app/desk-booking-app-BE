package com.team4.deskbookingappbe.service;

<<<<<<< HEAD
import com.team4.deskbookingappbe.model.api.CreateDeskRequest;
import com.team4.deskbookingappbe.model.domain.DtoDesk;
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
import com.team4.deskbookingappbe.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
@Service
public class DeskDataService {

    private final DeskRepository deskRepository;

    @Autowired
    public DeskDataService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }
<<<<<<< HEAD

    public DtoDesk createDesk(CreateDeskRequest request){
        DtoDesk desk = DtoDesk.builder()
                .deskName(request.getDeskName())
                .roomId(request.getRoomId())
                .build();

        return deskRepository.save(desk);
    }

    public List<DtoDesk> fetchDesks(Long id){
        return deskRepository.findAll();
    }

    public void deleteDesk(Long id){
        deskRepository.deleteById(id);
    }
=======
>>>>>>> c6f3dbc5d0e57ceffb4eec291d48cee7b8c2291d
}
