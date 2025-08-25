package org.trans.abelhinhaBackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class PublicController {
    
    @GetMapping("check")
    public ResponseEntity<String> checkRoute(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bem vindo ao backend Abelhinha!!");
    }

}
