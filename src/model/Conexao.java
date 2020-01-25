/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Racca
 */
public class Conexao {
    private static Connection conexao;
    private static final String DRIVE="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/auditoria";
    private static final String USER="root";
    private static final String PASS="";
    
    public static boolean conectaDB(){
        try {
            Class.forName(DRIVE);
            conexao=DriverManager.getConnection(URL, USER, PASS);
            //Properties clientInfo = conexao.getClientInfo();
            //System.out.println(conexao.getCatalog());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO ao conectar no banco");
            return false;
        }
        
    }
    
    public boolean fechaConexao(){
        
        try {   
            if(conexao!=null){
                conexao.close();
            }
                return true;      
        } catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public static void setConexao(Connection conexao) {
        Conexao.conexao = conexao;
    }
    
}
