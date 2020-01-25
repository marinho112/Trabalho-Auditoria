/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Racca
 */
public class ModelEficacia implements Cloneable{
    
    private int IdRisco;
    private int IdMitigacao;
    private int IdObjeto;
    private byte eficacia;
    
    
    public boolean getEficaciaById(int idR,int idM, int idO){
        Statement stmt;
        ResultSet rs;
        String querry="SELECT * FROM eficacia WHERE ID_Risco='"+idR+"'AND ID_Mitigacao='"+idM+"'AND ID_Objeto='"+idO+"' AND desativado=0";
        System.out.println(querry);
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(querry);
            rs.next();
            IdMitigacao=rs.getInt("ID_mitigacao");
            IdRisco=rs.getInt("ID_risco");
            IdObjeto=rs.getInt("ID_objeto");
            eficacia=rs.getByte("eficacia");
            
            
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no consulta de Eficacia");
            return false;
        }
    
}
    
    
    private boolean verificaEficaciaById(int idR,int idM, int idO){
        Statement stmt;
        ResultSet rs;
        try {
            stmt = Conexao.getConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM eficacia WHERE ID_Risco='"+idR+"'AND ID_Mitigacao='"+idM+"'AND ID_Objeto='"+idO+"' AND desativado=0");
            return rs.next();
        }catch (SQLException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO no verifica Eficacia");
            return false;
        }
    
}
    
    
   
    
    public boolean setAtributosEficacia(){
        PreparedStatement stmt;
        Statement stmt2;
        ResultSet rs;
        String sql;
        
        if(verificaEficaciaById(IdRisco,IdMitigacao,IdObjeto)){
            sql = "UPDATE eficacia SET eficacia=? desativado=0 WHERE ID_risco =? and ID_mitigacao=? and ID_objeto=?";
        }
        else{
            sql  = "INSERT INTO eficacia (eficacia,ID_risco,ID_mitigacao,ID_objeto,desativado) VALUES(?,?,?,?,0)";
        }

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,Integer.toString(eficacia));
            stmt.setString(2,Integer.toString(IdRisco));
            stmt.setString(3,Integer.toString(IdMitigacao));
            stmt.setString(4,Integer.toString(IdObjeto));
            
            
            
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();
            
            
            return true;
            }catch (SQLException ex) {
                Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERRO no set de Eficacia");
                return false;
            }
    }
    
    
    public boolean excluir() {
        PreparedStatement stmt;
        
        String sql="delete from eficacia where ID_Risco ='"+IdRisco+"' AND  ID_Mitigacao= '"+IdMitigacao+"'AND  ID_Objeto= '"+IdObjeto+"'";
          try { 
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.execute(sql);
            return true;
          }
          catch (SQLException e) { 
              return false;
          }
    }
     
    public void test(){
        System.out.println("IdRisco: "+IdRisco);
        System.out.println("IdMitigacao: "+IdMitigacao);
        System.out.println("IdObjeto: "+IdObjeto);
        System.out.println("Eficacia: "+eficacia);
    }

    public void setIdRisco(int IdRisco) {
        this.IdRisco = IdRisco;
    }

    public void setIdMitigacao(int IdMitigacao) {
        this.IdMitigacao = IdMitigacao;
    }

    public void setEficacia(byte eficacia) {
        this.eficacia = eficacia;
    }

    public void setIdObjeto(int IdObjeto) {
        this.IdObjeto = IdObjeto;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public int getIdRisco() {
        return IdRisco;
    }

    public int getIdMitigacao() {
        return IdMitigacao;
    }

    public byte getEficacia() {
        return eficacia;
    }
    
     @Override
    public ModelEficacia clone() throws CloneNotSupportedException{
        return (ModelEficacia) super.clone();
    }
    
}
