package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Cliente;
import br.com.cinejov.factories.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public void inserir(Cliente c) throws SQLException{
        String sql = "INSERT INTO CLIENTE (NOME, EMAIL, SENHA) VALUES (?, ?, ?)"; //passa as Strings
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        //passa os parametros
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getEmail());
        stmt.setString(3, c.getSenha());
        
        stmt.execute();//executar
        
        //fechar
        stmt.close();
        conexao.close();
                      
    }
    
    public Cliente procurarPorEmail(String email) throws SQLException{
        String sql = "SELECT ID, NOME, EMAIL, SENHA FROM CLIENTE WHERE EMAIL = ?";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        //passa os parametros
        stmt.setString(1, email);
            
       ResultSet rs = stmt.executeQuery();
       
       Cliente cliente = null;
       
       while(rs.next()){
           Cliente c = new Cliente();
           c.setNome(rs.getString("NOME"));
           c.setEmail(rs.getString("EMAIL"));
           c.setSenha(rs.getString("SENHA"));
           c.setId(rs.getInt("ID"));
           cliente=c; 
        }
        
        //fechar
        stmt.close();
        conexao.close();
        
        return cliente;
    }
    
    public Cliente autenticar(String email, String senha) throws SQLException{
        Cliente c = null;
        
        String sql ="SELECT ID, NOME, EMAIL, SENHA FROM CLIENTE WHERE EMAIL = ? AND SENHA = ?";
        
         Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            c = new Cliente();
            c.setId(rs.getInt("ID"));
            c.setNome(rs.getString("NOME"));
           c.setEmail(rs.getString("EMAIL"));
           c.setSenha(rs.getString("SENHA"));
        }
        stmt.close();
        conexao.close();
        return c;
    }
}
