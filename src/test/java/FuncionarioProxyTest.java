import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addFuncionario(new Funcionario("1", "João", 950.0f));
        BD.addFuncionario(new Funcionario("2", "Maria", 1000.0f));
    }

    @Test
    void deveRetornarDadosPessoaisFuncionarios() {
        FuncionarioProxy funcionario = new FuncionarioProxy("1");
        assertEquals(Arrays.asList("João"), funcionario.obterDadosPessoais());
    }

    @Test
    void deveRetonarSalarioFuncionario() {
        Dono dono = new Dono("Lara", true);
        FuncionarioProxy funcionario = new FuncionarioProxy("1");

        assertEquals(Arrays.asList(950.0f), funcionario.obterSalario(dono));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarNotasAluno() {
        try {
            Dono dono = new Dono("Josué", false);
            FuncionarioProxy funcionario = new FuncionarioProxy("2");

            funcionario.obterSalario(dono);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Socio nao autorizado", e.getMessage());
        }
    }

}