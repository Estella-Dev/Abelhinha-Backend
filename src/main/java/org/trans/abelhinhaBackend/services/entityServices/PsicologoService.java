package org.trans.abelhinhaBackend.services.entityServices;

import org.springframework.stereotype.Service;
import org.trans.abelhinhaBackend.repositories.PsicologoRepository;

@Service
public class PsicologoService {
    
    private PsicologoRepository psicologoRepository;

    public PsicologoService(PsicologoRepository psicologoRepository){
        this.psicologoRepository = psicologoRepository;
    }


}
