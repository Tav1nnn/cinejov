/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Sala;
import br.com.cinejov.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Otavio
 */
public class SalaDAO {
    public void inserir(Sala s) throws SQLException{
        String sql = "INSERT INTO SALA (NOME) VALUES (?)";
         Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, s.getNome());
        
        stmt.execute();
        stmt.close();
        conexao.close();
                
    }
    
    public ArrayList<Sala> selecionarTodos() throws SQLException{
        ArrayList<Sala> retorno = new ArrayList();
        String sql = "SELECT ID, NOME FROM SALA";
        
         Connection conexao = new ConnectionFactory().getConnection(); 
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Sala s = new Sala();
            
            s.setId(rs.getInt("ID"));
            s.setNome(rs.getString("NOME"));
            
            retorno.add(s);
        }
        
        stmt.close();
        conexao.close();
        
        return retorno;
    }
    
    public Sala procurarNome(String nome) throws SQLException{
        Sala s = null;
        String sql = "SELECT ID, NOME FROM SALA WHERE NOME = ?";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           s = new Sala();
           s.setId(rs.getInt("ID"));
           s.setNome(rs.getString("NOME"));        
        }
          stmt.close();
        conexao.close();
        
        return s;
    }
    
    public Sala procurarPorID(int id) throws SQLException{
        String sql = "SELECT ID, NOME FROM SALA WHERE ID = ?";
         Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
         
        stmt.setInt(1, id);
        
        Sala s = null;
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            s = new Sala();
            
            s.setId(rs.getInt("ID"));
            s.setNome(rs.getString("NOME"));
            
        }
        
        return s;
    }
    
}
