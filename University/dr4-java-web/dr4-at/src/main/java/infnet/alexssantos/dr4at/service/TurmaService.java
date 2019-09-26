package infnet.alexssantos.dr4at.service;

import infnet.alexssantos.dr4at.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository dao;
}
