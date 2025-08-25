package org.trans.abelhinhaBackend.helpers.requests;

public record PsicologoRequest(
    String nome,
    String foto,
    String descricao,
    String crp,
    String preco,
    Boolean atendeOnline,
    String estado,
    String cidade,
    String telefone,
    String whatsapp,
    String instagram
) {
    
}
