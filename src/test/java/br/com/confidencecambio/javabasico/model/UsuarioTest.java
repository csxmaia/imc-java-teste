package br.com.confidencecambio.javabasico.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class UsuarioTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    //Nome não pode ser nulo
    @Test
    public void exceptionSetNomeNulo(){
        Usuario usuario = new Usuario();
        exception.expect(RuntimeException.class);
        usuario.setNome(null);
    }

    //Nome não pode ser vazio
    @Test
    public void exceptionSetNomeVazio(){
        Usuario usuario = new Usuario();
        exception.expect(RuntimeException.class);
        usuario.setNome("     ");
    }

    private Usuario getEntradaUsuarioNomeComEspaco() {
        Usuario usuario = new Usuario();
        usuario.setNome(" João Soares Silva ");
        usuario.setAltura(123);
        usuario.setPeso(123);
        return usuario;
    }

    //Nome não pode conter espaços extras no início e no fim
    @Test
    public void validarTratamentoEspacosSetNome(){
        Usuario usuarioRequest = getEntradaUsuarioNomeComEspaco();
        assertEquals("João Soares Silva", usuarioRequest.getNome());
        usuarioRequest.setNome("João Soares Silva ");
        assertEquals("João Soares Silva", usuarioRequest.getNome());
        usuarioRequest.setNome("   João Soares Silva");
        assertEquals("João Soares Silva", usuarioRequest.getNome());
    }

    private Usuario getEntradaUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("João Soares Silva");
        usuario.setAltura(123);
        usuario.setPeso(123);
        return usuario;
    }

    @Test
    public void validarGettersRequisitos(){
        Usuario usuarioRequest = getEntradaUsuario();
        assertEquals("João", usuarioRequest.getPrimeiroNome());
        assertEquals("Soares Silva", usuarioRequest.getUltimoNome());
        assertEquals("JOÃO SOARES SILVA", usuarioRequest.getNomeTodoMaiusculo());
        assertEquals("João S. Silva", usuarioRequest.getNomeAbreviado());
    }

    private Usuario getEntradaUsuarioPreposicao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Cristhian da Silveira Maia");
        usuario.setAltura(123);
        usuario.setPeso(123);
        return usuario;
    }

    @Test
    public void validarPreposicaoAbreviacao(){
        Usuario usuarioRequest = getEntradaUsuarioPreposicao();
        assertEquals("Cristhian S. Maia", usuarioRequest.getNomeAbreviado());
    }
}
