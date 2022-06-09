package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;

public interface ImcService {
    Double calcularImc(UsuarioDTO usuarioDTO);
}
