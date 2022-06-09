package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;
import br.com.confidencecambio.javabasico.model.Usuario;
import br.com.confidencecambio.javabasico.service.ImcService;
import br.com.confidencecambio.javabasico.service.ImcServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;

public class ImcControllerTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private ImcController imcController;
    private ImcService imcService;

    @Before
    public void init(){
        imcService = new ImcServiceImpl();
        imcController = new ImcController(imcService);
    }

    private UsuarioDTO getEntradaUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("João Soares Silva");
        usuarioDTO.setAltura(1.75);
        usuarioDTO.setPeso(76);
        return usuarioDTO;
    }

    @Test
    public void validarCalculo(){
        UsuarioDTO usuarioDTO = getEntradaUsuario();
        ResponseEntity<Double> valorValido = imcController.realizarCalculoImc(usuarioDTO);
        assertEquals(new Double(25), valorValido.getBody());
    }

    @Test
    public void validarCalculoNomeNull(){
        UsuarioDTO usuarioDTO = getEntradaUsuario();
        exception.expect(ResponseStatusException.class);
        usuarioDTO.setNome(null);
        ResponseEntity<Double> valorValido = imcController.realizarCalculoImc(usuarioDTO);
        assertEquals(new Double(25), valorValido.getBody());
    }

    @Test
    public void validarCalculoNomeVazio(){
        UsuarioDTO usuarioDTO = getEntradaUsuario();
        exception.expect(ResponseStatusException.class);
        usuarioDTO.setNome("   ");
        ResponseEntity<Double> valorValido = imcController.realizarCalculoImc(usuarioDTO);
        assertEquals(new Double(25), valorValido.getBody());
    }
}
