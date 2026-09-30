import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class CalculadoraProcedimento {

    private final Map<TipoProcedimento, PoliticaPrecoProcedimento> politicas;

    public CalculadoraProcedimento() {

        politicas = new EnumMap<>(TipoProcedimento.class);

        politicas.put(
                TipoProcedimento.BASICO,
                new PrecoProcedimentoBasico()
        );

        politicas.put(
                TipoProcedimento.COMUM,
                new PrecoProcedimentoComum()
        );

        politicas.put(
                TipoProcedimento.AVANCADO,
                new PrecoProcedimentoAvancado()
        );
    }

    public double calcular(Procedimento procedimento) {

        if (procedimento == null) {
            return 0.0;
        }

        PoliticaPrecoProcedimento politica =
                politicas.get(procedimento.getTipoProcedimento());

        if (politica == null) {
            throw new IllegalArgumentException(
                    "Tipo de procedimento não suportado: "
                            + procedimento.getTipoProcedimento()
            );
        }

        return politica.calcular();
    }

    public double calcularTotal(List<Procedimento> procedimentos) {

        if (procedimentos == null || procedimentos.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Procedimento procedimento : procedimentos) {
            total += calcular(procedimento);
        }

        return total;
    }
}