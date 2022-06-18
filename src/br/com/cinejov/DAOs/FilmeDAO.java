/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Filme;
import br.com.cinejov.entities.Sala;
import br.com.cinejov.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Otavio
 */
public class FilmeDAO {
    public void inserir(Filme f) throws SQLException{
        String sql = "INSERT INTO FILME (NOME, DESCRICAO, DURACAO) VALUES (?,?,?)";
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getDescricao());
        stmt.setInt(3, f.getDuracao());
        
          
        stmt.execute();
        stmt.close();
        conexao.close();
    }
      public ArrayList<Filme> selecionarTodos() throws SQLException{
        ArrayList<Filme> retorno = new ArrayList();
        String sql = "SELECT ID, NOME, DESCRICAO, DURACAO FROM FILME";
        
         Connection conexao = new ConnectionFactory().getConnection(); 
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Filme f = new Filme();
            
            f.setId(rs.getInt("ID"));
            f.setNome(rs.getString("NOME"));
            f.setDescricao(rs.getString("DESCRICAO"));
            f.setDuracao(rs.getInt("DURACAO"));
            
            retorno.add(f);
        }
        
        stmt.close();
        conexao.close();
        
        return retorno;
    }
    public Filme procurarNome(String nome) throws SQLException{
        Filme f = null;
        String sql = "SELECT ID, NOME, DESCRICAO, DURACAO FROM FILME WHERE NOME = ?";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           f = new Filme();
           
           f.setId(rs.getInt("ID"));
           f.setNome(rs.getString("NOME"));
           f.setDescricao(rs.getString("DESCRICAO"));
           f.setDuracao(rs.getInt("DURACAO"));
           
        }
         stmt.close();
        conexao.close();
        
        return f;
    }
    
    public Filme procurarPorId(int id) throws SQLException{
        Filme f = null;
        String sql = "SELECT ID, NOME, DESCRICAO, DURACAO FROM FILME WHERE ID = ?";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           f = new Filme();
           
           f.setId(rs.getInt("ID"));
           f.setNome(rs.getString("NOME"));
           f.setDescricao(rs.getString("DESCRICAO"));
           f.setDuracao(rs.getInt("DURACAO")); 
        }
        
        stmt.close();
        conexao.close();
        
        return f;
    }
}
