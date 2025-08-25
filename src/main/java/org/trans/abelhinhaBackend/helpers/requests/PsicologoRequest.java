package org.trans.abelhinhaBackend.helpers.requests;

import jakarta.validation.constraints.NotBlank;

public record PsicologoRequest(
    @NotBlank(message = "O nome é obrigatório") String nome,
    String foto,
    String descricao,
    @NotBlank(message = "O CRP é obrigatório") String crp,
    String preco,
    @NotBlank(message = "Marque sim ou não para atendimento online") Boolean atendeOnline,
    String estado,
    String cidade,
    @NotBlank(message = "O telefone é obrigatório") String telefone,
    @NotBlank(message = "O whatsapp é obrigatório") String whatsapp,
    String instagram
) {
    
}
