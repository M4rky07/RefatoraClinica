public class CalculadoraInternacao {

    public double calcular(Internacao internacao) {

        if (internacao == null) {
            return 0;
        }

        PoliticaPrecoLeito politica = obterPolitica(internacao.getTipoLeito());

        return politica.calcular(internacao.getQtdeDias());
    }

    private PoliticaPrecoLeito obterPolitica(TipoLeito tipoLeito) {

        switch (tipoLeito) {
            case ENFERMARIA:
                return new PrecoEnfermaria();

            case APARTAMENTO:
                return new PrecoApartamento();

            default:
                throw new IllegalArgumentException(
                    "Tipo de leito não suportado"
                );
        }
    }
}