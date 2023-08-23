package mapa.entidades;

import javax.swing.JOptionPane;

public class Glicemia extends Exame {
    private double qtddGlicose;

    public Glicemia(String nomePaciente, String tipoSanguineo, int anoNascimento) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
    }
    
    
    

    @Override
    public String ClassificarResultado() {
        if (qtddGlicose < 100) {
            return "Normoglicemia";
        } else if (qtddGlicose < 126) {
            return "Pré-diabetes";
        } else {
            return "Diabetes estabelecido";
        }
    }

    @Override
    public void CadastrarExame() {
        this.qtddGlicose = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade de glicose"));
            
    }

    @Override
    public void MostrarResultado() {
        String mensagemFormatada = "";
        mensagemFormatada += ("Olá, "+getNomePaciente()+"!");
        mensagemFormatada += ("\nVocê informou que a quantidade de glicose foi "+ qtddGlicose +"!");
        mensagemFormatada += ("\nResultado do exame: \n" + ClassificarResultado());
        JOptionPane.showMessageDialog(null,mensagemFormatada);
    }
}
