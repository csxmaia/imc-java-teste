package br.com.confidencecambio.javabasico.dto;

import br.com.confidencecambio.javabasico.model.Usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioDTO {
    @NotNull(message = "O nome não pode ser nulo!")
    @NotEmpty(message = "O nome não pode ser vazio!")
    private String nome;

    private double peso;

    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setAltura(this.altura);
        usuario.setPeso(this.peso);
        return usuario;
    }
}
