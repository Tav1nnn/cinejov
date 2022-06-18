/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Ingresso;
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
public class IngressoDAO {
    
    public ArrayList<Ingresso> procurarPorSessao(int idSessao) throws SQLException{
        String sql = "SELECT ID, LUGAR, ID_SESSAO, ID_CLIENTE FROM INGRESSO WHERE ID_SESSAO = ?";
        
        ArrayList<Ingresso> retorno = new ArrayList();
        
        Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setInt(1, idSessao);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Ingresso i = new Ingresso();
            i.setId(rs.getInt("ID"));
            i.setLugar(rs.getInt("LUGAR"));
            i.setIdSessao(rs.getInt("ID_SESSAO"));
            i.setIdCliente(rs.getInt("ID_CLIENTE"));
            
            retorno.add(i);
            
        }
        return retorno;
    }
    
    public void inserirIngresso(Ingresso i) throws SQLException{
        String sql ="INSERT INTO INGRESSO (LUGAR, ID_SESSAO, ID_CLIENTE) VALUES (?, ?, ?)";
          Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setInt(1, i.getLugar());
        stmt.setInt(2, i.getIdSessao());
        stmt.setInt(3, i.getIdCliente());
        
        stmt.execute();
        stmt.close();
        conexao.close();
        
        
    }
    
}
