package br.com.confidencecambio.javabasico.mapper;

import br.com.confidencecambio.javabasico.dto.UsuarioDTO;
import br.com.confidencecambio.javabasico.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public Usuario toModel (UsuarioDTO usuarioDTO);

    public UsuarioDTO toDTO (Usuario usuario);
}
