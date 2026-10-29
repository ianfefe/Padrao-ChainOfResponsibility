import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AprovadorTest {

    private Aprovador aprovador;

    @BeforeEach
    public void setUp() {
        aprovador = new AprovadorSupervisor(
                new AprovadorGerente(
                        new AprovadorDiretor(
                                new AprovadorPresidente(null))));
    }

    @Test
    void deveAprovarSolicitacaoPeloSupervisor() {
        Solicitacao solicitacao = new Solicitacao("Material de escritório", 500.0);
        assertEquals("Solicitação aprovada pelo Supervisor", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveAprovarSolicitacaoNoLimiteDoSupervisor() {
        Solicitacao solicitacao = new Solicitacao("Cadeiras", 1000.0);
        assertEquals("Solicitação aprovada pelo Supervisor", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveAprovarSolicitacaoPeloGerente() {
        Solicitacao solicitacao = new Solicitacao("Notebook", 3000.0);
        assertEquals("Solicitação aprovada pelo Gerente", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveAprovarSolicitacaoPeloDiretor() {
        Solicitacao solicitacao = new Solicitacao("Servidor", 15000.0);
        assertEquals("Solicitação aprovada pelo Diretor", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveAprovarSolicitacaoPeloPresidente() {
        Solicitacao solicitacao = new Solicitacao("Veículo", 80000.0);
        assertEquals("Solicitação aprovada pelo Presidente", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveNegarSolicitacaoAcimaDeTodosOsLimites() {
        Solicitacao solicitacao = new Solicitacao("Imóvel", 500000.0);
        assertEquals("Solicitação negada", aprovador.aprovar(solicitacao));
    }

    @Test
    void deveNegarSolicitacaoSemSuperior() {
        Aprovador gerente = new AprovadorGerente(null);
        Solicitacao solicitacao = new Solicitacao("Servidor", 15000.0);
        assertEquals("Solicitação negada", gerente.aprovar(solicitacao));
    }

    @Test
    void deveIniciarCadeiaPeloGerente() {
        Aprovador gerente = new AprovadorGerente(new AprovadorDiretor(null));
        Solicitacao solicitacao = new Solicitacao("Material de escritório", 500.0);
        assertEquals("Solicitação aprovada pelo Gerente", gerente.aprovar(solicitacao));
    }

    @Test
    void devePermitirAlterarSuperior() {
        Aprovador supervisor = new AprovadorSupervisor(null);
        supervisor.setSuperior(new AprovadorPresidente(null));
        Solicitacao solicitacao = new Solicitacao("Notebook", 3000.0);
        assertEquals("Solicitação aprovada pelo Presidente", supervisor.aprovar(solicitacao));
    }
}
