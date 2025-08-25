package org.trans.abelhinhaBackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trans.abelhinhaBackend.helpers.requests.PsicologoRequest;
import org.trans.abelhinhaBackend.helpers.responses.PsicologoResponse;
import org.trans.abelhinhaBackend.services.entityServices.PsicologoService;

@Controller
@RequestMapping("api/psicologo")
public class PsicologoController {
    
    private PsicologoService psicologoService;

    public PsicologoController(PsicologoService psicologoService){
        this.psicologoService = psicologoService;
    }

    @PostMapping("cadastro")
    public ResponseEntity<PsicologoResponse> cadastro(@RequestBody PsicologoRequest request){

        

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new PsicologoResponse());
    }

}
