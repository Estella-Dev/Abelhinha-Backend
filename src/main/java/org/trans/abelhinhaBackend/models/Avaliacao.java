package org.trans.abelhinhaBackend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int note;
    @Column(length = 500, nullable = false)
    private String text;
    @Column(length = 200, nullable = false, unique = true)
    private String comprovante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;
    @Column
    private LocalDateTime dataAvaliacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getComprovante() {
        return comprovante;
    }
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }
    public Psicologo getPsicologo() {
        return psicologo;
    }
    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }
    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    

}
