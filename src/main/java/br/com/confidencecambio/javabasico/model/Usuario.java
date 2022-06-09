package br.com.confidencecambio.javabasico.model;

import br.com.confidencecambio.javabasico.util.StringUtils;
import br.com.confidencecambio.javabasico.util.UsuarioUtils;

public class Usuario {
    private String nome;
    private double peso;
    private double altura;

    public Usuario() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("O atributo nome não pode ser nulo ou vazio!");
        }
        this.nome = StringUtils.removeSpacesAtStartEnd(nome);
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

    public String getPrimeiroNome() {
        return UsuarioUtils.primeiroNome(this.nome);
    }

    public String getUltimoNome() {
        return UsuarioUtils.ultimoNome(this.nome);
    }

    public String getNomeTodoMaiusculo() {
        return UsuarioUtils.nomeTodoMaiusculo(this.nome);
    }

    public String getNomeAbreviado() {
       return UsuarioUtils.nomeAbreviado(this.nome);
    }
}
