package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository dao;
}
