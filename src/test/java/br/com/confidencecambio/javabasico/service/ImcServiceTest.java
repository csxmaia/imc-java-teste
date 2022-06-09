package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImcServiceTest {

    private ImcService imcService;

    @Before
    public void init(){
        imcService = new ImcServiceImpl();
    }

    private UsuarioDTO getEntradaUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("João Soares Silva");
        usuarioDTO.setAltura(1.75);
        usuarioDTO.setPeso(76);
        return usuarioDTO;
    }

    @Test
    public void retornarImc(){
        UsuarioDTO usuarioRequest = getEntradaUsuario();
        Double imc = imcService.calcularImc(usuarioRequest);
        assertEquals(new Double(25), imc);
    }
}
