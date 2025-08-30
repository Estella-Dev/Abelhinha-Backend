package org.trans.abelhinhaBackend.services.entityServices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    // Converte um psicologo model em um response
    private PsicologoResponse toResponse(Psicologo psicologo){
        PsicologoResponse response = new PsicologoResponse();
        BeanUtils.copyProperties(psicologo, response);
        return response;
    }

    // Converte um psicologo request em um model
    private Psicologo toPsicologo(PsicologoRequest request){
        Psicologo psicologo = new Psicologo();
        BeanUtils.copyProperties(request, psicologo);
        return psicologo;
    }

    // Cadastra novo psicologo passando todos os dados necessários
    public PsicologoResponse cadastrar(PsicologoRequest request){
        Psicologo psicologo = toPsicologo(request);
        psicologo.setDataRegistro(LocalDateTime.now());

        PsicologoResponse response = this.toResponse(
                this.psicologoRepository.save(
                    psicologo));
        return response;
    }

    // Retorna uma lista de psicologo response
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

    // Encontra um psicologo por id e retorna os dados em uma response
    public PsicologoResponse encontrarPorId(String id){
        Optional<Psicologo> psicologo = this.psicologoRepository.findById(UUID.fromString(id));
        if(psicologo.isPresent()){
            PsicologoResponse response = this.toResponse(psicologo.get());
            return response;
        }
        return new PsicologoResponse();
    }


    // Deleta um psicologo utilizando o seu id e retorn um verdadeiro ou falso
    public Boolean deletarPsicologo(String id){
        Optional<Psicologo> psicologo = this.psicologoRepository.findById(UUID.fromString(id));

        if(psicologo.isPresent()){
            this.psicologoRepository.delete(psicologo.get());;
            return true;
        }

        return false;
    }

}
