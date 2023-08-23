
package mapa.entidades;

import java.time.LocalDate;

public abstract class Exame {
    private final String nomePaciente;
    private final String tipoSanguineo;
    private final int anoNascimento;
    
    // Construtor
    protected Exame(String nomePaciente, String tipoSanguineo, int anoNascimento) {
        this.nomePaciente = nomePaciente;
        this.tipoSanguineo = tipoSanguineo;
        this.anoNascimento = anoNascimento;
    }

    // Getters
    protected String getNomePaciente() {
        return nomePaciente;
    }

    // Método abstrato para classificar o resultado
    public abstract String ClassificarResultado();

    // Método abstrato para mostrar o resultado
    public abstract void MostrarResultado();
    
    // Método abstrato para classificar o resultado
    public abstract void CadastrarExame();
    

    
    // Método para calcular a idade do paciente
    protected int CalcularIdade() {
        int anoAtual = LocalDate.now().getYear();
        return anoAtual - anoNascimento;
    }
}
