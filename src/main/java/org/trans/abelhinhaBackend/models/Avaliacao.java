package org.trans.abelhinhaBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    
    public Long id;
    public int note;
    public String text;

}
