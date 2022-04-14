package com.team4.deskbookingappbe.service;

import com.team4.deskbookingappbe.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeskDataService {

    private final DeskRepository deskRepository;

    @Autowired
    public DeskDataService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }
}
