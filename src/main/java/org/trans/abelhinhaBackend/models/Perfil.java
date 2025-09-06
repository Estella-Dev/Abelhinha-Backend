package org.trans.abelhinhaBackend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfils")
public class Perfil {
    
    private Long id;
    private String nome;
    private String foto;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Avaliacao> avaliacoes;

}
