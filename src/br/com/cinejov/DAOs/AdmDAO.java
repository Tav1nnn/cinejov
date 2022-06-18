/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinejov.DAOs;

import br.com.cinejov.entities.Administrador;
import br.com.cinejov.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Otavio
 */
public class AdmDAO {
    public Administrador autenticar(String email, String senha) throws SQLException{
        Administrador a = null;
        
        String sql ="SELECT ID, NOME, EMAIL, SENHA FROM ADMINISTRADOR WHERE EMAIL = ? AND SENHA = ?";
        
         Connection conexao = new ConnectionFactory().getConnection(); //cria conexao
        
        PreparedStatement stmt = conexao.prepareStatement(sql); // executa comandos
        
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            a = new Administrador();
            a.setId(rs.getInt("ID"));
            a.setNome(rs.getString("NOME"));
           a.setEmail(rs.getString("EMAIL"));
           a.setSenha(rs.getString("SENHA"));
        }
        stmt.close();
        conexao.close();
        return a;
        
    }
}
