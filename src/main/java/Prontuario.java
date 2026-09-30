
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prontuario {

    private String nomePaciente;
    private Internacao internacao;
    private final List<Procedimento> procedimentos = new ArrayList<>();

    public Prontuario(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Internacao getInternacao() {
        return internacao;
    }

    public void setInternacao(Internacao internacao) {
        this.internacao = internacao;
    }

    public void addProcedimento(Procedimento procedimento) {
        procedimentos.add(procedimento);
    }

    public List<Procedimento> getProcedimentos() {
        return Collections.unmodifiableList(procedimentos);
    }
}