/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.dao;

import java.sql.ResultSet;
import core.dao.conexao.ConexaoJDBC;
import java.sql.PreparedStatement;
import core.entity.PessoaEntity;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author solem
 */
public class PessoaDAO {
    public boolean inserir(PessoaEntity pessoaEntity){
        
        String sql = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
        
        PreparedStatement ps;
        
        try {
            if (pessoaEntity.getLogin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "É necessário preencher o campo login!");
            }
            else if (pessoaEntity.getSenha().isEmpty()) {
                JOptionPane.showMessageDialog(null, "É necessário preencher o campo senha!");
            }
            else{
                ps = ConexaoJDBC.getConexao().prepareStatement(sql);
                ps.setString(1, pessoaEntity.getNome());
                ps.setString(2, pessoaEntity.getLogin());
                ps.setString(3, pessoaEntity.getSenha());
                ps.setString(4, pessoaEntity.getEmail());

                ps.execute();
            
                String sqlConsulta = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
                ResultSet rs;
                ps = ConexaoJDBC.getConexao().prepareStatement(sqlConsulta);
                ps.setString(1, pessoaEntity.getLogin());
                ps.setString(2, pessoaEntity.getSenha());

                rs = ps.executeQuery();
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não efetuado. Tente novamente!");
                }
                ps.close();
                rs.close();
            }
        } catch (HeadlessException | SQLException e) {
        }           
        return false;
    }
        public void entrar(PessoaEntity pessoaEntity){
        
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            if (pessoaEntity.getLogin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "É necessário preencher o campo login!");
            }else if (pessoaEntity.getSenha().isEmpty()) {
                JOptionPane.showMessageDialog(null, "É necessário preencher o campo senha!");
            }else{
                ps = ConexaoJDBC.getConexao().prepareStatement(sql);
                ps.setString(1, pessoaEntity.getLogin());
                ps.setString(2, pessoaEntity.getSenha());

                rs = ps.executeQuery();
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "Acesso permitido!");
                }else{
                    JOptionPane.showMessageDialog(null, "Acesso não permitido. Confira login e senha inserido ou cadastre-se!");
                }
                ps.close();
                rs.close();
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }         
    }
}
