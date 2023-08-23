
package mapa;


import javax.swing.JOptionPane;
import mapa.entidades.Colesterol;
import mapa.entidades.Glicemia;
import mapa.entidades.Triglicerideos;

public class Mapa {

    public static void main(String[] args) {
        CadastrarExame();
    }
        public static void CadastrarExame(){
        int tipo;
        
            JOptionPane.showMessageDialog(null,"Para utilizar o software, é necessário que insira alguns dados!");
            String nomePaciente =JOptionPane.showInputDialog("Qual o seu nome?");
            String tipoSanguineo = JOptionPane.showInputDialog("Qual o seu tipo sanguíneo?"); 
            int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Você nasceu em qual ano?"));  
        
        do {
                tipo = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    Nosso software possui com um leque de 3 exames e voc\u00ea pode fazer quantos quiser. Escolha uma opção digitando seu número:
                                                                     1 - Glicemia
                                                                     2 - Colesterol
                                                                     3 - Triglicer\u00eddeos
                                                                     0 - Sair"""));
                
                switch (tipo) {
                case 1 -> {
                    Glicemia glicemia = new Glicemia(nomePaciente, tipoSanguineo, anoNascimento);
                    glicemia.CadastrarExame();
                    glicemia.MostrarResultado();
                    }
                case 2 -> {
                    Colesterol colesterol = new Colesterol(nomePaciente, tipoSanguineo, anoNascimento);
                    colesterol.CadastrarExame();
                    colesterol.MostrarResultado();
                    }
                case 3 -> {
                    Triglicerideos triglicerideos = new Triglicerideos(nomePaciente, tipoSanguineo, anoNascimento);
                    triglicerideos.CadastrarExame();
                    triglicerideos.MostrarResultado();
                    }
                default -> {
                    tipo = 0;
                    }
            }
        } while (tipo != 0);
    }
    
}
