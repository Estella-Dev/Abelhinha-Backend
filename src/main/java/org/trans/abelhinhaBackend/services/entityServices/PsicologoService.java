package org.trans.abelhinhaBackend.services.entityServices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.trans.abelhinhaBackend.helpers.requests.PsicologoRequest;
import org.trans.abelhinhaBackend.helpers.responses.PsicologoResponse;
import org.trans.abelhinhaBackend.models.Psicologo;
import org.trans.abelhinhaBackend.repositories.PsicologoRepository;

@Service
public class PsicologoService {
    
    private PsicologoRepository psicologoRepository;

    public PsicologoService(PsicologoRepository psicologoRepository){
        this.psicologoRepository = psicologoRepository;
    }

    private PsicologoResponse toResponse(Psicologo psicologo){
        PsicologoResponse response = new PsicologoResponse();
        BeanUtils.copyProperties(psicologo, response);
        return response;
    }

    private Psicologo toPsicologo(PsicologoRequest request){
        Psicologo psicologo = new Psicologo();
        BeanUtils.copyProperties(request, psicologo);
        return psicologo;
    }

    public PsicologoResponse cadastrar(PsicologoRequest request){
        Psicologo psicologo = toPsicologo(request);
        psicologo.setDataRegistro(LocalDateTime.now());

        PsicologoResponse response = this.toResponse(
                this.psicologoRepository.save(
                    psicologo));
        return response;
    }

    public List<PsicologoResponse> listarTodos(){
        List<Psicologo> psicologos = this.psicologoRepository.findAll();
        List<PsicologoResponse> responses = new ArrayList<>();

        for (Psicologo psicologo : psicologos) {
            PsicologoResponse response = new PsicologoResponse();
            BeanUtils.copyProperties(psicologo, response);
            responses.add(response);
        }

        return responses;
    }

}
