/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Sessao;
import br.com.cinejov.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import jdk.dynalink.linker.support.Guards;
import java.sql.ResultSet;

/**
 *
 * @author Otavio
 */
public class SessaoDAO {
    
    public void inserir(Sessao s) throws SQLException{
        String sql = "INSERT INTO SESSAO (HORARIO, ID_FILME, ID_SALA) VALUES (?,?,?)";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, s.getHorario());
        stmt.setInt(2, s.getIdFilme());
        stmt.setInt(3, s.getIdSala());
        
        stmt.execute();
        stmt.close();
        conexao.close();
    }
    
    public ArrayList<Sessao> procurarPorFilme(int id) throws SQLException{
        ArrayList<Sessao> retorno = new ArrayList();
        
        String sql ="SELECT ID, HORARIO, ID_FILME, ID_SALA FROM SESSAO WHERE ID_FILME = ?";
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Sessao s = new Sessao();
            
            s.setId(rs.getInt("ID"));
            s.setHorario(rs.getString("HORARIO"));
            s.setIdFilme(rs.getInt("ID_FILME"));
            s.setIdSala(rs.getInt("ID_SALA"));
            
            retorno.add(s);
        }
        stmt.close();
        conexao.close();
        return retorno;
    }
    
   
    
    public Sessao procurarSessao(int idSala, int idFilme, String horario) throws SQLException {
        String sql = "SELECT ID, HORARIO, ID_FILME, ID_SALA FROM SESSAO WHERE ID_SALA = ? AND ID_FILME = ? AND HORARIO = ?";
        
        Sessao s = null;
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setInt(1, idSala);
        stmt.setInt(2, idFilme);
        stmt.setString(3, horario);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            s = new Sessao();
            s.setId(rs.getInt("ID"));
            s.setHorario(rs.getString("HORARIO"));
            s.setIdFilme(rs.getInt("ID_FILME"));
            s.setIdSala(rs.getInt("ID_SALA"));
        }
        
        return s;
    }
    
    public Sessao procurarUmaSessao (int idFilme, String horario) throws SQLException {
        String sql = "SELECT ID, HORARIO, ID_FILME, ID_SALA FROM SESSAO WHERE ID_FILME = ? AND HORARIO = ?";
        
        Sessao s = null;
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setInt(1, idFilme);
        stmt.setString(2, horario);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            s = new Sessao();
            s.setId(rs.getInt("ID"));
            s.setHorario(rs.getString("HORARIO"));
            s.setIdFilme(rs.getInt("ID_FILME"));
            s.setIdSala(rs.getInt("ID_SALA"));
        }
        
        return s;
    }
    
}
