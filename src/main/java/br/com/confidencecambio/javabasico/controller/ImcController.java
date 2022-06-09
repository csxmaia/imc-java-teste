package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;
import br.com.confidencecambio.javabasico.service.ImcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/imc")
public class ImcController {
    private ImcService imcService;

    public ImcController(final ImcService imcService) {
        this.imcService = imcService;
    }

    @RequestMapping(value = "/calcularImc", method = RequestMethod.POST)
    public ResponseEntity<Double> realizarCalculoImc(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Double imc = imcService.calcularImc(usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body(imc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getCause());
        }
    }
}
