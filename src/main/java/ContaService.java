public class ContaService {

    private final CalculadoraInternacao calculadoraInternacao;
    private final CalculadoraProcedimento calculadoraProcedimento;

    public ContaService(
            CalculadoraInternacao calculadoraInternacao,
            CalculadoraProcedimento calculadoraProcedimento) {

        this.calculadoraInternacao = calculadoraInternacao;
        this.calculadoraProcedimento = calculadoraProcedimento;
    }

    public double calcularTotal(Prontuario prontuario) {

        double valorInternacao =
                calculadoraInternacao.calcular(
                    prontuario.getInternacao()
                );

        double valorProcedimentos =
                calculadoraProcedimento.calcularTotal(
                    prontuario.getProcedimentos()
                );

        return valorInternacao + valorProcedimentos;
    }
}