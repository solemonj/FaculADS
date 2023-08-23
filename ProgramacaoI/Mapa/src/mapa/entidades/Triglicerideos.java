package mapa.entidades;

import javax.swing.JOptionPane;

public class Triglicerideos extends Exame {
    private double qtddTriglicerideo;
    
    public Triglicerideos(String nomePaciente, String tipoSanguineo, int anoNascimento) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
    }

    @Override
    public String ClassificarResultado() {
        if (CalcularIdade() < 10) {
            return qtddTriglicerideo < 75 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos";
        } else if (CalcularIdade() < 20) {
            return qtddTriglicerideo < 90 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos";
        } else {
            return qtddTriglicerideo < 150 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos";
        }
    }

    @Override
    public void CadastrarExame() {
        this.qtddTriglicerideo = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade de triglicerídeos"));
    }

    @Override
    public void MostrarResultado() {
        
        String mensagemFormatada = "";
        mensagemFormatada += ("Olá, "+getNomePaciente()+"!");
        mensagemFormatada += ("\nVocê informou que a quantidade de triglicerídeos foi "+ qtddTriglicerideo +"!");
        mensagemFormatada += ("\nResultado do exame: \n" + ClassificarResultado());
        
        JOptionPane.showMessageDialog(null,mensagemFormatada);
    }
}
