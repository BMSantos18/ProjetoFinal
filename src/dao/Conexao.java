package dao;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexao {
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql:ProjetoFinal","postgres","postgres");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            return con;
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, "O banco de dados não foi conectado. Contacte o adm do sistema!");
            return null;
        }
    }
    
}