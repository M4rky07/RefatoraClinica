import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ProntuarioTest {

    @Test
    public void deveCriarProntuarioComNomePaciente() {

        Prontuario prontuario =
                new Prontuario("Paul McCartney");

        assertEquals(
                "Paul McCartney",
                prontuario.getNomePaciente()
        );
    }

    @Test
    public void deveAdicionarProcedimentosAoProntuario() {

        Prontuario prontuario =
                new Prontuario("Paul McCartney");

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.BASICO)
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.AVANCADO)
        );

        assertEquals(
                2,
                prontuario.getProcedimentos().size()
        );
    }

    @Test
    public void deveAdicionarInternacaoAoProntuario() {

        Prontuario prontuario =
                new Prontuario("MC Criolo");

        Internacao internacao =
                new Internacao(
                        TipoLeito.ENFERMARIA,
                        1
                );

        prontuario.setInternacao(internacao);

        assertNotNull(prontuario.getInternacao());

        assertEquals(
                TipoLeito.ENFERMARIA,
                prontuario.getInternacao().getTipoLeito()
        );

        assertEquals(
                1,
                prontuario.getInternacao().getQtdeDias()
        );
    }

    @Test
    public void devePermitirProntuarioSemInternacao() {

        Prontuario prontuario =
                new Prontuario("Paul McCartney");

        assertNull(
                prontuario.getInternacao()
        );
    }

    @Test
    public void deveCalcularContaSomenteComProcedimentos() {

        Prontuario prontuario =
                new Prontuario("Paul McCartney");

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.BASICO)
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.AVANCADO)
        );

        ContaService contaService =
                new ContaService(
                        new CalculadoraInternacao(),
                        new CalculadoraProcedimento()
                );

        double total =
                contaService.calcularTotal(prontuario);

        assertEquals(
                550.00,
                total,
                0.001
        );
    }

    @Test
    public void deveCalcularContaComInternacaoEProcedimentos() {

        Prontuario prontuario =
                new Prontuario("Nando Reis");

        prontuario.setInternacao(
                new Internacao(
                        TipoLeito.APARTAMENTO,
                        4
                )
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.BASICO)
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.COMUM)
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.COMUM)
        );

        prontuario.addProcedimento(
                new Procedimento(TipoProcedimento.AVANCADO)
        );

        ContaService contaService =
                new ContaService(
                        new CalculadoraInternacao(),
                        new CalculadoraProcedimento()
                );

        double total =
                contaService.calcularTotal(prontuario);

        assertEquals(
                1210.00,
                total,
                0.001
        );
    }

    @Test
    public void deveCalcularContaSomenteComInternacao() {

        Prontuario prontuario =
                new Prontuario("MC Criolo");

        prontuario.setInternacao(
                new Internacao(
                        TipoLeito.ENFERMARIA,
                        1
                )
        );

        ContaService contaService =
                new ContaService(
                        new CalculadoraInternacao(),
                        new CalculadoraProcedimento()
                );

        double total =
                contaService.calcularTotal(prontuario);

        assertEquals(
                40.00,
                total,
                0.001
        );
    }
}