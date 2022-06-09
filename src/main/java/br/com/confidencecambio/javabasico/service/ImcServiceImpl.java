package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;
import br.com.confidencecambio.javabasico.model.Usuario;
import br.com.confidencecambio.javabasico.util.ImcUtils;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class ImcServiceImpl implements ImcService{

    @Override
    public Double calcularImc(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toUsuario();

        Double peso = usuario.getPeso();
        Double altura = usuario.getAltura();
        Double imc = ImcUtils.realizarCalculoImc(peso, altura);

        DecimalFormat df = new DecimalFormat("#,##");
        imc = Double.valueOf(df.format(imc));

        return imc;
    }
}
