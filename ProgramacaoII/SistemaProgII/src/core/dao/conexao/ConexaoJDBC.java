/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author solem
 */
public class ConexaoJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/mapa";
    private static final String user = "root";
    private static final String password = "root";
    
    public static Connection conn;
    
    public static Connection getConexao() {
       
        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Houve um erro ao tentar conectar no banco de dados");
            return null;
        }
        
    }
}
