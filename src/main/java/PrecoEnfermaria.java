public class PrecoEnfermaria implements PoliticaPrecoLeito {

    @Override
    public double calcular(int quantidadeDias) {

        if (quantidadeDias <= 3) {
            return 40.00 * quantidadeDias;
        }

        if (quantidadeDias <= 8) {
            return 35.00 * quantidadeDias;
        }

        return 30.00 * quantidadeDias;
    }
}