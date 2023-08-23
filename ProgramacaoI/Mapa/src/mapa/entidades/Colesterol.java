package mapa.entidades;

import javax.swing.JOptionPane;

public class Colesterol extends Exame {
    private double qtddHDL;
    private double qtddLDL;
    private String riscoPaciente;

    public Colesterol(String nomePaciente, String tipoSanguineo, int anoNascimento) {
        super(nomePaciente, tipoSanguineo, anoNascimento);
    }

    @Override
    public String ClassificarResultado() {
        String resultado = "";
        resultado += ("\nHDL: ");
        if (CalcularIdade() <= 19) {
            resultado += (qtddHDL > 45 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos");
        } else {
            resultado += (qtddHDL > 40 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos");
        }

        resultado += ("\nLDL: ");
        switch (riscoPaciente) {
            case "B" -> resultado += (qtddLDL < 100 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos");
            case "M" -> resultado += (qtddLDL < 70 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos");
            case "A" -> resultado += (qtddLDL < 50 ? "Está dentro dos padrões estabelecidos" : "Está fora dos padrões estabelecidos");
        }

        return resultado;
    }

    @Override
    public void CadastrarExame() {
        this.qtddHDL = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade do colesterol HDL")); 
        this.qtddLDL = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade do colesterol LDL"));  
        this.riscoPaciente = JOptionPane.showInputDialog("""
                                                                    Informe o seu grau de risco
                                                                     B - Baixo
                                                                     M - Médio
                                                                     A - Alto""").toUpperCase();
    }

    @Override
    public void MostrarResultado() {
        String mensagemFormatada = "";
        mensagemFormatada += "Olá, "+getNomePaciente()+"!";
        mensagemFormatada += "\nVocê informou que a quantidade LDL é "+ qtddLDL +", e HDL é "+ qtddHDL +" ";
        mensagemFormatada += "\nAlém disso, informou que seu risco como paciente é: "+ riscoPaciente;
        mensagemFormatada += "\nResultado do exame: " + ClassificarResultado();
        JOptionPane.showMessageDialog(null,mensagemFormatada);
    }

}
