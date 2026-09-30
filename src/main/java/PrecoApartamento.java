public class PrecoApartamento implements PoliticaPrecoLeito {

    @Override
    public double calcular(int quantidadeDias) {

        if (quantidadeDias <= 3) {
            return 100.00 * quantidadeDias;
        }

        if (quantidadeDias <= 8) {
            return 90.00 * quantidadeDias;
        }

        return 80.00 * quantidadeDias;
    }
}