package org.trans.abelhinhaBackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trans.abelhinhaBackend.models.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, UUID>{
    
}
